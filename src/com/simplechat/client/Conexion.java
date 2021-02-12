package com.simplechat.client;

import com.simplechat.common.IOStream;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;


public class Conexion {
    private Socket socket;
    private InetSocketAddress addr;
    private IOStream data;

    public Conexion(String ip, int port) throws IOException{
        socket = new Socket();
        addr = new InetSocketAddress(ip,port);
        socket.connect(addr);
        data = new IOStream(socket.getInputStream(),socket.getOutputStream());
    }

    public Socket getSocket(){
        return socket;
    }

    public void closeSocket() throws IOException{
        socket.close();
    }

    public boolean connected() throws IOException{
        return data.getDataTypeInput().readBoolean();
    }

    public IOStream getData(){
        return data;
    }
}
