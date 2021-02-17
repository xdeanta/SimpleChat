package com.simplechat.server;

import com.simplechat.common.IOStream;
import com.simplechat.common.Conexion;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ConexionServer extends Conexion{

    public ConexionServer(String ip, int port) throws IOException{
        sSocket = new ServerSocket();
        addr = new InetSocketAddress(ip,port);
        sSocket.bind(addr);
        data = new IOStream(socket.getInputStream(),socket.getOutputStream());
    }

}
