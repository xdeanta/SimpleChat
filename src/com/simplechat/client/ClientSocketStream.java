package com.simplechat.client;

import com.simplechat.common.SocketStream;

import java.io.IOException;
import java.net.Socket;

public class ClientSocketStream extends SocketStream {
    public ClientSocketStream(String ip, int port) throws IOException {
        socket = new Socket();
        createAddress(ip,port);
        connectClient();
        createIOStream();
    }
    public void connectClient(){
        try {
            socket.connect(addr);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
