package com.example.arqdsis.prova201510845;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText textNome;
    String pais;
    ArrayList<Pais> lista;
    PaisRequester requester;
    Intent intent;
    String chave;

    public static final String SERVIDOR = "https://restcountries.eu/rest/v2/region/";
    public static final String LISTA = "com.example.arqdsis.prova201510845.lista";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNome = (EditText)findViewById(R.id.buscar_pais);
    }

    public void buscarPais(View view){
        intent = new Intent(this, ListarPaisesActivity.class);
        chave = textNome.getText().toString();
        requester = new PaisRequester();
        if(requester.isConnected(this)){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lista = requester.get(SERVIDOR, chave);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Lista: "+lista);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            intent.putExtra(LISTA, lista);
                            startActivity(intent);
                        }
                    });

                }
            }).start();

        } else {
            Toast toast = Toast.makeText(this, "Rede indisponível", Toast.LENGTH_LONG);
            toast.show();
        }

    }

}

