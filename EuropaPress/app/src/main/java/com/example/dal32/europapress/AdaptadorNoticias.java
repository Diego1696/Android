package com.example.dal32.europapress;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dal32 on 25/10/2017.
 */

public class AdaptadorNoticias extends ArrayAdapter {

    Activity activity;
    List<Noticia> lista;

    public AdaptadorNoticias(Activity context, List<Noticia> lista) {
        super(context, R.layout.tituloydesc, lista);
        activity = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.tituloydesc, null);

        TextView tit = (TextView) view.findViewById(R.id.lblTitulo);
        TextView desc = (TextView) view.findViewById(R.id.lblDescripcion);

        tit.setText(lista.get(position).getTitulo());
        desc.setText(lista.get(position).getDescripcion());

        return view;
    }
}
