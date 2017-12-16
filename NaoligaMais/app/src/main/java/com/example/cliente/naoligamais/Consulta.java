package com.example.cliente.naoligamais;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Cliente on 16/12/2017.
 */

public class Consulta extends Activity {
    private ListView Listar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] { CriaBanco.NUMERO};
        int[] idViews = new int[] { R.id.listView};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_lista,cursor,nomeCampos,idViews, 0);
        Listar = (ListView)findViewById(R.id.listView);
        Listar.setAdapter(adaptador);
    }
}
