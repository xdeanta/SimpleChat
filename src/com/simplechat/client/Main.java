package com.simplechat.client;



import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            ConexionCliente conx = new ConexionCliente("192.168.56.2", 7500);
            if(conx.connected()){
                System.out.println("Conectado");
            }
            conx.getData().getDataTypeOutput().writeBoolean(true);
            conx.closeSocket();
        }catch (IOException e){
            System.out.println("Error al intentar conectar con el servidor");
        }
    }
}
