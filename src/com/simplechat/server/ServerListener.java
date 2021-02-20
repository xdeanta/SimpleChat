package com.simplechat.server;

import java.io.IOException;

public class ServerListener extends Thread{
    private ServerSocketStream serversocket;

    public ServerListener() {
        serversocket = new ServerSocketStream("192.168.56.2", 7500);
    }

    public void run(){
        serversocket.acceptConnection();
    }
}
