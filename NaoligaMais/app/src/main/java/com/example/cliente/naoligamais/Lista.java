package com.example.cliente.naoligamais;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    private ListView listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);



        //String te= "ate aki no listagem";

        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        listar = (ListView)findViewById(R.id.listView);

        ArrayList<String> listaNumeros = new ArrayList<>();

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                String numero = cursor.getString(1);
                listaNumeros.add(numero);
            } while (cursor.moveToNext());

        }

        BaseAdapterLista baseAdapterLista = new BaseAdapterLista(listaNumeros, this);

        listar.setAdapter(baseAdapterLista);
        baseAdapterLista.notifyDataSetChanged();
        listar.setAdapter(baseAdapterLista);

        //Toast.makeText(getApplicationContext(),te , Toast.LENGTH_SHORT).show();
    }
}
