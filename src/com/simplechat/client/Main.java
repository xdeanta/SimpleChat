package com.simplechat.client;



import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Conexion conx = new Conexion("192.168.56.2", 7500);
            conx.connected();
            conx.getData().getDataTypeOutput().writeBoolean(true);
        }catch (IOException e){
            System.out.println("Error al intentar conectar con el servidor");
        }
    }
}
