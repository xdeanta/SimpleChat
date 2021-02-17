package com.simplechat.server;

import com.simplechat.common.IOStream;

public class RegisteredClient extends Thread{
    private IOStream data;
    private String username;
    private String password;

    public RegisteredClient(String usr, String pswd, IOStream data){
        username=usr;
        password=pswd;
        this.data=data;
    }

    public RegisteredClient(){
        this(null,null,null);
    }

    public void sendMsg(String message){

    }

    public void recieveMsg(){

    }

    public static void login(){

    }

    public void exit(){

    }

    public void run(){

    }
}
