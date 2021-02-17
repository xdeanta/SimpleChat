package com.simplechat.client;

public class Client {
    private String usrname;
    private String password;

    public Client(String usr, String pswd){
        usrname=usr;
        password=pswd;
    }

    public Client(){
        this(null,null);
    }

}
