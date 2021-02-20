package com.simplechat.client;

import com.simplechat.common.SocketStream;

import java.net.Socket;

public class ClientSocketStream extends SocketStream {
    public ClientSocketStream(String ip, int port){
        socket = new Socket();
        createAddress(ip,port);
    }

}
