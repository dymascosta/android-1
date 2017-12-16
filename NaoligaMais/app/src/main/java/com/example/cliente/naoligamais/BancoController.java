package com.example.cliente.naoligamais;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;


/**
 * Created by Cliente on 14/12/2017.
 */

public class BancoController {

    private SQLiteDatabase db;
    public CriaBanco dadosbanco;



    public BancoController(Context context)
    {
        dadosbanco = new CriaBanco(context);
    }

    public String InsereDado(String numero)
    {
        ContentValues valores;
        long result;

        db = dadosbanco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NUMERO,numero);

        result = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (result==-1) return "Erro ao inserir os dados ";

        else  return "Dados inseridos com sucesso ";

    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {dadosbanco.ID,dadosbanco.NUMERO};
        db = dadosbanco.getReadableDatabase();
        cursor = db.query(dadosbanco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }



}
