package com.simplechat.client;

import java.io.Serializable;

public class Client implements Serializable {
    private String username;

    public Client(Client c){
        this(c.getUsername());
    }

    public Client(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
