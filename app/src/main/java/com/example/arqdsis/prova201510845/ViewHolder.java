package com.example.arqdsis.prova201510845;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by arqdsis on 05/05/2017.
 */
public class ViewHolder {
    private TextView nomePais, detalhePais;

    public ViewHolder(TextView nomePais, TextView detalhePais) {
        this.nomePais = nomePais;
        this.detalhePais = detalhePais;
    }

    public TextView getNomeCliente() {
        return nomePais;
    }

    public void setNomePais(TextView nomePais) {
        this.nomePais = nomePais;
    }

    public TextView getDetalheCliente() {
        return detalhePais;
    }

    public void setDetalhePais(TextView detalhePais) {
        this.detalhePais = detalhePais;
    }
}

