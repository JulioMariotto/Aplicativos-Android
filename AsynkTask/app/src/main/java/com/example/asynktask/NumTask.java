package com.example.asynktask;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class NumTask extends AsyncTask<Integer, Integer, Void> {

    private TextView tv;
    private Button bt;

    public NumTask(TextView tv, Button bt) {
        this.tv = tv;
        this.bt = bt;
    }

    public TextView getTv() {
        return tv;
    }

    public void setTv(TextView tv) {
        this.tv = tv;
    }

    public Button getBt() {
        return bt;
    }

    public void setBt(Button bt) {
        this.bt = bt;
    }

    @Override
    protected Void doInBackground(Integer... params) {

        int n = params[0];
        int i = 0;
        while (i < n){
            try {
                if(i > 100)
                    Thread.sleep(10);
                if(i > 20 )
                    Thread.sleep(100);
                else
                    Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            publishProgress(i);
            i++;
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        tv.setText(String.valueOf(values[0]));
    }
}
