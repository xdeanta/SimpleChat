package com.simplechat.common;

import com.simplechat.client.Client;

public class Message {
    private Client client;
    private String str;

    public Message(Client c, String str){
        client=c;
        this.str=str;
    }

    public String showMessage(){
        return "[" + client.getUsername() + "]: " + str;
    }
}
