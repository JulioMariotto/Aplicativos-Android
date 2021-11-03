package com.example.tempclient;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Conversor extends Thread {

    private float tempF, tempC;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private boolean type;
    private static final String ip = "192.168.1.2";
    private static final int porta = 12345;

    private Handler handler;

    public Conversor(float tempC, Handler handler, boolean type) {
        this.tempC = tempC;
        this.handler = handler;
        this.type = type;
    }

    @Override
    public void run() {
        super.run();
        try{
            socket = new Socket(ip, porta);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            out.writeFloat(tempC);
            out.writeBoolean(type);
            out.flush();
            tempF = in.readFloat();
            out.close();
            in.close();
            socket.close();
            Bundle b = new Bundle();
            b.putFloat("resultado", tempF);
            Message msg = new Message();
            if(type)
                msg.what = 2;
            else
                msg.what = 1;
            msg.setData(b);
            handler.sendMessage(msg);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
