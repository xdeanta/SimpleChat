package com.simplechat.client;

import com.simplechat.common.Message;

import java.io.IOException;

public class MessageReceiver extends Thread{
    private ClientSocketStream cSocket;

    public MessageReceiver(ClientSocketStream socket){
        cSocket = socket;
    }

    @Override
    public void run(){
        Message msg;
        while (true){
            try {
                msg=(Message) cSocket.getIostream().getObjin().readObject();
                System.out.println(msg);
            }catch (IOException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e2){
                e2.printStackTrace();
            }
        }
    }
}
