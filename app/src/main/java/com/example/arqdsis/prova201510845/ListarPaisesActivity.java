package com.example.arqdsis.prova201510845;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarPaisesActivity extends AppCompatActivity {

    ListView listView;
    Pais[] lista;
    public static final String CLIENTE = "com.example.arqdsis.prova201510845.cliente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_paises);
        listView = (ListView) findViewById(R.id.lista_de_clientes);
        Intent intent = getIntent();
        ArrayList<Pais> clientes = (ArrayList<Pais>)intent.getSerializableExtra(MainActivity.LISTA);
        System.out.println("Paises: "+clientes);
        lista = clientes.toArray(new Pais[0]);

        BaseAdapter adapter = new PaisAdapter(this, lista);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(ListarPaisesActivity.this, DetalhePaisActivity.class);
                intent1.putExtra(CLIENTE, lista[i]);
                startActivity(intent1);
            }
        });

    }
}
