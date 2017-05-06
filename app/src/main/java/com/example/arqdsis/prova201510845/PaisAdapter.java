package com.example.arqdsis.prova201510845;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by arqdsis on 05/05/2017.
 */
public class PaisAdapter extends BaseAdapter {
    Pais[] paises;
    Activity context;

    public PaisAdapter(Activity context, Pais[] paises){
        this.context = context;
        this.paises = paises;
    }

    @Override
    public int getCount() {
        return paises.length;
    }

    @Override
    public Object getItem(int i) {
        if(i >= 0 && i < paises.length){
            return paises[i];
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View viewReciclada, ViewGroup viewGroup) {
        View view = viewReciclada;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_pais, viewGroup, false);
            TextView nomePais = (TextView) view.findViewById(R.id.nome_pais);
            TextView detalhePais = (TextView) view.findViewById(R.id.detalhe_pais);
            //faz cache dos widgets na tagview para usar quando houver reciclagem
            view.setTag(new ViewHolder( nomePais, detalhePais));
        }
        //usar os widgets cachedados na tag da view reciclada
        ViewHolder holder = (ViewHolder)view.getTag();
        //carrega os novos valores
        holder.getNomeCliente().setText(paises[i].getNome());
        holder.getDetalheCliente().setText(paises[i].getCapital() + "  -  "+paises[i].getPopulacao());


        return view;
    }
}
