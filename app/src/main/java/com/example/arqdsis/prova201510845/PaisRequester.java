package com.example.arqdsis.prova201510845;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by arqdsis on 05/05/2017.
 */
public class PaisRequester {
    OkHttpClient client = new OkHttpClient();

    public ArrayList<Pais> get (String url, String chave) throws IOException {
        ArrayList<Pais> lista = new ArrayList<>();

        if(chave != null && chave.length() > 0){
            url += "/"+chave;
        }
        System.out.println("URL: "+url);
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String jsonString = response.body().string();
        System.out.println("JSON: "+jsonString);

        try {
            JSONArray root = new JSONArray(jsonString);
            JSONObject item = null;
            for(int i = 0; i < root.length(); i++){
                item = (JSONObject)root.get(i);
                String nome = item.getString("name");
                String capital = item.getString("capital");
                String area = item.getString("area");
                String populacao = item.getString("population");
                String moeda = item.getString("name");
                Pais pais = new Pais(nome, capital, area, populacao, moeda);
                lista.add(pais);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Bitmap getImage(String url) throws  IOException{
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        InputStream is = response.body().byteStream();

        Bitmap img = BitmapFactory.decodeStream(is);

        is.close();

        return img;
    }

    public boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
