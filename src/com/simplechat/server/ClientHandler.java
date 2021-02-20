package com.simplechat.server;

import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket clientSocket;

    public ClientHandler(Socket socket){
        clientSocket = socket;
    }
}
