package com.simplechat.server;

import java.io.IOException;
import java.util.Queue;


public class Main {

    public static void main(String args[]){
        try {
            ConexionServer conx = new ConexionServer("192.168.56.2", 7500);
            //while(true) {
                conx.acceptConnection();
           //}

            conx.closeSockets();
        }catch (IOException e){
            System.out.println("Error al intentar conectar con el servidor");
        }
    }
}
