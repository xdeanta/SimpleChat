package com.simplechat.server;

import com.simplechat.client.Client;
import com.simplechat.common.Message;

import java.io.IOException;

public class UserThread extends Thread{
    private Client c;
    private ServerSocketStream sSocket;
    private Channel ch;

    public UserThread(ServerSocketStream sSocket) {
        this.sSocket=sSocket;
    }

    public void setClient(){
        try {
            c = (Client)sSocket.getIostream().getObjin().readObject();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e2){
            e2.printStackTrace();
        }
    }

    public void setChannel(Channel c){
        ch=c;
    }

    public void messageToChannel(Message msg){
        ch.addMessage(msg);
    }

    public void messageToUsers(Message msg){
        try {
            sSocket.getIostream().getObjout().writeObject(msg);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        Message msg;
        try{
            setClient();
            sSocket.getIostream().getDataTypeOutput().writeUTF("Bienvenido " + c.getUsername());
            while (true){
                /*String str = sSocket.getIostream().getDataTypeInput().readUTF();
                System.out.println("Mensaje recibido: " + str);*/
                msg=(Message) sSocket.getIostream().getObjin().readObject();
                if(msg.getStr().equals("bye")){
                    sSocket.getIostream().getDataTypeOutput().writeUTF("disconnecting...");
                    break;
                }else {
                    //msg = new Message(c, str);
                    messageToChannel(msg);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e2){
            e2.printStackTrace();
        }
    }
}
