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

    public void sendMessage(Message msg){
        ch.addMessage(msg);
    }

    public void run(){
        Message msg;
        try{
            sSocket.getIostream().getDataTypeOutput().writeUTF("Bienvenido " + c.getUsername());
            while (true){
                String str = sSocket.getIostream().getDataTypeInput().readUTF();
                if(str.equals("bye")){
                    sSocket.getIostream().getDataTypeOutput().writeUTF("disconnecting...");
                    break;
                }else {
                    msg = new Message(c, str);
                    sendMessage(msg);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
