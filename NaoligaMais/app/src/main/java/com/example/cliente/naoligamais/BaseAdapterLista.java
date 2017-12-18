package com.example.cliente.naoligamais;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cliente on 16/12/2017.
 */

public class BaseAdapterLista extends BaseAdapter {

    private ArrayList<String> listaNumeros;
    private Context context;




    public BaseAdapterLista (ArrayList<String> listaNumeros, Context context) {
        this.listaNumeros = listaNumeros;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaNumeros.size();
    }

    @Override
    public Object getItem(int position) {
        return listaNumeros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final BancoController crud = new BancoController(context);
        final Cursor cursor = crud.carregaDados();

        LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.listview_numeros, null);

        TextView numeroView = (TextView)  layout.findViewById(R.id.numeroBloqueado);
        String numero = listaNumeros.get(position);
        numeroView.setText(numero);

        ImageButton button = (ImageButton) layout.findViewById(R.id.numeroBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idNumero = cursor.getString(0);
                listaNumeros.remove(position);
                crud.deletaRegistro(idNumero);
                notifyDataSetChanged();


            }
        });

        return layout;
    }
}
