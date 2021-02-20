package com.simplechat.common;

import java.io.*;
import java.util.Scanner;

public class IOStream {
    private Scanner entry;
    private DataInputStream is;
    private DataOutputStream os;
    private ObjectOutputStream Objout;
    private ObjectInputStream Objin;
    private static IOStream ios;

    private IOStream(InputStream in, OutputStream out) throws IOException {
        entry = new Scanner(System.in);
        is = new DataInputStream(in);
        os = new DataOutputStream(out);
        Objout = new ObjectOutputStream(out);
        Objin = new ObjectInputStream(in);
    }

    public static IOStream getInstance(InputStream in, OutputStream out) throws IOException{
        if(ios == null){
            ios = new IOStream(in,out);
        }
        return ios;
    }

    public Scanner getStandardInput(){
        return entry;
    }

    public DataInputStream getDataTypeInput(){
        return is;
    }

    public DataOutputStream getDataTypeOutput(){
        return os;
    }

    public ObjectOutputStream getObjout() {
        return Objout;
    }

    public ObjectInputStream getObjin() {
        return Objin;
    }
}
