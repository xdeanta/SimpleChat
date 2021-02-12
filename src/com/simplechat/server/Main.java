package com.simplechat.server;

import java.io.IOException;

public class Main {
    public static void main(String args[]){
        try {
            Conexion conx = new Conexion("192.168.56.2", 7500);
            conx.acceptConnection();
            conx.confirmConnection();
            conx.closeSockets();
        }catch (IOException e){
            System.out.println("Error al intentar conectar con el servidor");
        }
    }
}
