package com.simplechat.client;

import com.simplechat.common.Conexion;
import com.simplechat.common.IOStream;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;


public class ConexionCliente extends Conexion {

    public ConexionCliente(String ip, int port) throws IOException{
        socket = new Socket();
        addr = new InetSocketAddress(ip,port);
        socket.connect(addr);
        data = new IOStream(socket.getInputStream(),socket.getOutputStream());
    }
    public void closeSocket() throws IOException{
        socket.close();
    }
    public IOStream getData(){
        return data;
    }
}
