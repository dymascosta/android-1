package com.example.cliente.naoligamais;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cliente on 14/12/2017.
 */

public class CriaBanco extends SQLiteOpenHelper
{

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "fone";
    public static final String ID = "_id";
    public static final String NUMERO = "numero";
    public static final int VERSAO = 1;


    public CriaBanco(Context context)
    {
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE"+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + NUMERO + " text,"
                +")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
