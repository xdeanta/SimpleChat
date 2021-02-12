package com.simplechat.server;

import com.simplechat.common.IOStream;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Conexion {
    private ServerSocket sSocket;
    private Socket socket;
    private InetSocketAddress addr;
    private IOStream data;

    public Conexion(String ip, int port) throws IOException{
        sSocket = new ServerSocket();
        addr = new InetSocketAddress(ip,port);
        sSocket.bind(addr);
    }

    public Socket getSocket(){
        return socket;
    }

    public void closeSockets() throws IOException{
        socket.close();
        sSocket.close();
    }

    public void confirmConnection() throws IOException{
        data.getDataTypeOutput().writeBoolean(true);
    }

    public boolean connected() throws IOException{
        return data.getDataTypeInput().readBoolean();
    }

    public void acceptConnection() {
        try {
            socket = sSocket.accept();
            data = new IOStream(socket.getInputStream(),socket.getOutputStream());
            confirmConnection();
            connected();
        }catch (IOException e){
            System.out.println("No se pudo acceptar la conexion");
        }
    }


}
