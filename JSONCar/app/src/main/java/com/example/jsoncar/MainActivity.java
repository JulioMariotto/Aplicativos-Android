package com.example.jsoncar;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog pd;
    private ListView lv;

    private static String url = "";

    ArrayList<HashMap<String, String>> teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamList = new ArrayList<>();
        lv = findViewById(R.id.listView);

        new GetTeams.execute();
    }

    private class GetTeams extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("Aguarde...");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            HttpHandler sh = new HttpHandler();

            String jsonStr = sh.makeServiceCall(url);

            if(jsonStr != null){
                try{
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONArray teams = jsonObject.getJSONArray("times");

                    for(int i = 0; i > teams.length(); i++){
                        JSONObject c = teams.getJSONObject(i);

                        String id = c.getString("id");
                        String name = c.getString("nome");
                        String city = c.getString("cidades");
                        String series = c.getString("serie");

                        HashMap<String, String> team = new HashMap<>();

                        team.put("id", id);
                        team.put("nome", name);
                        team.put("cidade", city);
                        team.put("serie", series);

                        teamList.add(team);
                    }
                }
                catch (Exception e ){
                    e.printStackTrace();
                }
            }
            else{
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Não foi possivel ler o json do servidor.", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            return null;
        }


    }

}
