package com.example.cliente.naoligamais;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;


/**
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String te= "ate aki";

        Toast.makeText(getApplicationContext(),te , Toast.LENGTH_SHORT).show();
    }

    public void btTela1(View view)
    {
        startActivity(new Intent(getBaseContext(), Block.class));
    }

    public void btTela2(View view) {

        startActivity(new Intent(getBaseContext(), Lista.class));
    }

}
