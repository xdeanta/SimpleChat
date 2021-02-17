package com.simplechat.client;

import com.simplechat.common.IOStream;

public class SocketHandler {
    private IOStream IOSocket;
    private static SocketHandler sh=null;

    private SocketHandler (IOStream ios){
        IOSocket=ios;
    }

    private static SocketHandler getSocketHandler(IOStream ios){
        if(sh == null){
            sh = new SocketHandler(ios);
        }
        return sh;
    }
}
