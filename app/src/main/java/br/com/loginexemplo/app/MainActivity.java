package br.com.loginexemplo.app;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt_userName, txt_password;
    Button btnLogin;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;

        txt_userName =  (EditText) findViewById(R.id.txt_userName);
        txt_password =  (EditText) findViewById(R.id.txt_password);
        btnLogin=  (Button) findViewById(R.id.btn_login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login();

            }
        });

    }


    private void login(){


        SQLiteDatabase db= new DatabaseHelper(context)
                .getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from user where userName = ? and password = ?;",
                new String[] {  txt_userName.getText().toString() ,
                                txt_password.getText().toString()  }
                );


        if(cursor.getCount() > 0){

            cursor.moveToFirst();

            Sessao.userName = cursor.getString(1);


            Log.d("Login", Sessao.userName);


            //Abrir tela principal"
            startActivity(
                new Intent(context, Main2Activity.class));

        }else{

            Toast.makeText(context, "Login invalido", Toast.LENGTH_SHORT).show();
        }


    }

}
