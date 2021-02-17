package com.simplechat.server;

import java.util.LinkedList;
import java.util.Queue;

public class Chat{
    private LinkedList<String> chat;
    public Chat (){
        chat = new LinkedList<>();
    }

    public Queue<String> getChat(){
        return chat;
    }

    public void addMessage(String message){
        chat.add(message);
    }
    public void clean(){
        if(chat.size() == 1000){
            chat.removeLast();
        }
    }
}
