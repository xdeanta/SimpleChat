package com.simplechat.server;

import com.simplechat.client.Client;

import java.util.ArrayList;

public class Channel {
    private String name;
    private Client[] clients;
    private final int MAX_CLIENTS = 10;
    private static final Channel main = new Channel();
    private ArrayList<String> messages;

    public String getName() {
        return name;
    }

    private Channel(){
        name = "#main";
        clients = new Client[MAX_CLIENTS];
        messages=new ArrayList<>();
    }

    public static Channel getChannel(){
        return main;
    }

    public synchronized void addMessage(String message){
        messages.add(message);
    }
    public void broadcastMessage(){

    }
}
