package com.simplechat.server;

import com.simplechat.client.Client;
import com.simplechat.common.Message;

import java.util.ArrayList;

public class Channel {
    private String name;
    private final int MAX_CLIENTS = 10;
    private static final Channel main = new Channel();
    private ArrayList<Message> messages;
    private ArrayList<UserThread> usuarios;
    private Message last;

    public String getName() {
        return name;
    }

    private Channel(){
        name = "#main";
        messages=new ArrayList<>();
        last=null;
    }

    public static Channel getChannel(){
        return main;
    }

    public synchronized void addMessage(Message message){
        messages.add(message);
        broadcastMessage();
    }

    public void setUsuarios(ArrayList<UserThread> usuarios){
        this.usuarios=usuarios;
    }

    public void broadcastMessage(){
        UserThread u;
        if(messages.size() > 0){
            for(int i = 0; i<usuarios.size();i++){
                u=usuarios.get(i);
                u.messageToUsers(messages.get(messages.size()));
            }
        }
    }
}
