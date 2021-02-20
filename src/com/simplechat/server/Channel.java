package com.simplechat.server;

import com.simplechat.client.Client;
import com.simplechat.common.Message;

import java.util.ArrayList;

public class Channel {
    private String name;
    private final int MAX_CLIENTS = 10;
    private static final Channel main = new Channel();
    private ArrayList<Message> messages;

    public String getName() {
        return name;
    }

    private Channel(){
        name = "#main";
        messages=new ArrayList<>();
    }

    public static Channel getChannel(){
        return main;
    }

    public synchronized void addMessage(Message message){
        messages.add(message);
    }

    public void broadcastMessage(){

    }
}
