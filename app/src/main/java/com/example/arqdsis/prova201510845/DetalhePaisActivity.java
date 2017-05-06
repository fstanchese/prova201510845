package com.example.arqdsis.prova201510845;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalhePaisActivity extends AppCompatActivity {

    TextView textViewNome, textViewFone, textViewEmail;
    ImageView imagemCliente;
    PaisRequester paisRequester;
    Pais pais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        textViewNome = (TextView) findViewById(R.id.txt_pais_nome);
        textViewPopulacao = (TextView) findViewById(R.id.txt_pais_populacao);
        Intent intent = getIntent();
        pais = (Pais)intent.getSerializableExtra(ListarPaisesActivity.CLIENTE);

        textViewNome.setText(pais.getNome());
        textViewPopulacao.setText(pais.getPopulacao());

        paisRequester = new PaisRequester();
    }
}


