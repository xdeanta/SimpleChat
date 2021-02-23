package com.simplechat.client;

import com.simplechat.common.Message;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Client c;
        ClientSocketStream clientSocket;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese usuario");
        String usrname = sc.nextLine();
        c = new Client(usrname);
        String str;
        Message msg;
        try {
            clientSocket = new ClientSocketStream("192.168.56.2",7500);
            clientSocket.connectClient();
            clientSocket.getIostream().getObjout().writeObject(c);
            System.out.println(clientSocket.getIostream().getDataTypeInput().readUTF());
            while(true){
                str = sc.nextLine();
                if(str.equals("bye")){
                    break;
                }
                msg = new Message(c,str);
                clientSocket.getIostream().getObjout().writeObject(msg);
                //clientSocket.getIostream().getDataTypeOutput().writeUTF(str);
            }
            clientSocket.closeSocket();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
