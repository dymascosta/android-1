package com.example.cliente.naoligamais;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        String te= "ate aki no listagem";


        Toast.makeText(getApplicationContext(),te , Toast.LENGTH_SHORT).show();
    }
}
