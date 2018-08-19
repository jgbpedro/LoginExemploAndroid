package br.com.loginexemplo.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sn1041520 on 22/11/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO ="login.db";
    private static final int VERSAO = 1;


    public DatabaseHelper(Context context){
        super(context,NOME_BANCO, null, VERSAO );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user( _id INTEGER PRIMARY KEY,userName TEXT, password TEXT);");

        db.execSQL("insert into user (userName,password) values('kassiano','1234');");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
