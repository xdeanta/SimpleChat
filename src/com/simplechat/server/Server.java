package com.simplechat.server;

import java.util.ArrayList;

public class Server {
    public static void main(String[] args){
        Channel c = Channel.getChannel();
        ArrayList<UserThread> usrs = new ArrayList<>();
        ServerListener sl = new ServerListener(usrs);
        sl.run();
        try {
            sl.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
