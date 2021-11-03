package com.example.tempserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerSocketThread extends Thread{

    private final Socket socket;

    public ServerSocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Float tempC = in.readFloat();
            boolean type = in.readBoolean();
            Float tempF;
            if(type == true) //celsius
                tempF = (float) ((tempC - 32) / 9) * 5;
            else //fahrenheit
                tempF = (float) (tempC / 5) * 9 + 32;

            out.writeFloat(tempF);
            out.flush();
            out.close();
            in.close();
            socket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
