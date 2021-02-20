package com.simplechat.client;

public class Client {
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
