package com.simplechat.common;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public abstract class Conexion {
    protected ServerSocket sSocket;
    protected Socket socket;
    protected InetSocketAddress addr;
    protected IOStream data;

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
            if(connected()){
                System.out.println("Cliente conectado");
            }
        }catch (IOException e){
            System.out.println("No se pudo acceptar la conexion");
        }
    }


}
