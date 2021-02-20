package com.simplechat.server;

import com.simplechat.common.SocketStream;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;


public class ServerSocketStream extends SocketStream {
    protected ServerSocket sSocket;

    public ServerSocketStream(String ip, int port) {
        try {
            sSocket = new ServerSocket();
            createAddress(ip, port);
            sSocket.bind(addr);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void acceptConnection(){
        try {
            socket = sSocket.accept();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void closeSocket() throws IOException{
        socket.close();
        sSocket.close();
    }

}
