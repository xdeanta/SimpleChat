package com.simplechat.common;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public abstract class SocketStream {
    protected Socket socket;
    protected InetSocketAddress addr;
    protected IOStream iostream;

    public Socket getSocket() {
        return socket;
    }

    public IOStream getIostream() {
        return iostream;
    }

    public void createAddress(String ip, int port){
        addr = new InetSocketAddress(ip,port);
    }

    public void closeSocket() throws IOException{
        socket.close();
    }

    public void createIOStream() throws IOException {
        iostream = IOStream.getInstance(socket.getInputStream(),socket.getOutputStream());
    }

}
