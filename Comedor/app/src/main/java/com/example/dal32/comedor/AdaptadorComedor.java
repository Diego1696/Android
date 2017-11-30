package com.example.dal32.comedor;

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

import com.example.dal32.comedor.Comedor;
import com.example.dal32.comedor.R;

import java.util.List;

/**
 * Created by dal32 on 25/10/2017.
 */

public class AdaptadorComedor extends ArrayAdapter {

    Activity activity;
    List<Comedor> lista;

    public AdaptadorComedor(Activity context, List<Comedor> lista) {
        super(context, R.layout.platos, lista);
        activity = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.platos, null);

        TextView tit = (TextView) view.findViewById(R.id.lblPlato1);
        TextView desc = (TextView) view.findViewById(R.id.lblPlato2);

        tit.setText(lista.get(position).getPlato1());
        desc.setText(lista.get(position).getPlato2());

        return view;
    }
}
