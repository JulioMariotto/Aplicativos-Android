package com.example.downloadtask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Auxiliar {

    public static Bitmap baixarImagem(String url) throws IOException{

        URL endereco;
        InputStream in;
        Bitmap img;

        endereco = new URL(url);
        in = endereco.openStream();
        img = BitmapFactory.decodeStream(in);

        in.close();

        return img;
    }
}
