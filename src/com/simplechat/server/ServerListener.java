package com.simplechat.server;

import java.io.IOException;
import java.util.ArrayList;

public class ServerListener extends Thread{
    private ServerSocketStream serverSocket;
    private ArrayList<UserThread> users;
    private Channel ch;

    public ServerListener(ArrayList<UserThread> usrs){
        serverSocket=new ServerSocketStream("192.168.56.2", 7500);
        users=usrs;
    }

    public void setCh(Channel c){
        ch = c;
    }

    public void run(){
        while(true){
            System.out.println("Escuchando...");
            serverSocket.acceptConnection();
            if(users.size() < 10) {
                System.out.println("Conexion Aceptada");
                UserThread usr = new UserThread(serverSocket);
                usr.setChannel(ch);
                users.add(usr);
                usr.start();
            }else{
                try {
                    serverSocket.getIostream().getDataTypeOutput().writeUTF("Conexion rechazada");
                    System.out.println("Conexion rechazada");
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    break;
                }
            }
        }

    }
}
