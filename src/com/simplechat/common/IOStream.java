package com.simplechat.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class IOStream {
    private Scanner entry;
    private DataInputStream is;
    private  DataOutputStream os;

    public IOStream(InputStream in, OutputStream out){
        entry = new Scanner(System.in);
        is = new DataInputStream(in);
        os = new DataOutputStream(out);
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
}
