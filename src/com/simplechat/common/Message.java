package com.simplechat.common;

import com.simplechat.client.Client;

import java.io.Serializable;

public class Message implements Serializable {
    private Client client;
    private String str;

    public Message(Client c, String str){
        client=c;
        this.str=str;
    }

    public String showMessage(){
        return "[" + client.getUsername() + "]: " + str;
    }

    public String getStr(){
        return str;
    }
}
