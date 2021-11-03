package com.example.downloadtask;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

public class DownloadTaks extends AsyncTask<String, Void, Bitmap> {

    private ImageView img;
    private EditText et;
    private Context ctx;
    private ProgressDialog pd;

    public DownloadTaks(ImageView img, Context ctx) {
        this.img = img;
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = ProgressDialog.show(ctx, "Por favor aguarde... ", "Baixando imagem...");
    }

    @Override
    protected Bitmap doInBackground(String... strings) {

        Bitmap img = null;
        try{
            img = Auxiliar.baixarImagem(strings[0]);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return img;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        img.setImageBitmap(bitmap);
        pd.dismiss();
    }
}

