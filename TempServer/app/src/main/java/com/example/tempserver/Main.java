package com.example.tempserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final int porta = 12345;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(porta);
        while (true){
            Socket socket = serverSocket.accept();
            new ServerSocketThread(socket).start();
        }
    }
}
