package com.example.cliente.naoligamais;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Block extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block);

        Toast.makeText(getApplicationContext(), "digite (ddd)xxxxxxxxx ",Toast.LENGTH_SHORT).show();

        Button botao = (Button)findViewById(R.id.salvar);

        final EditText numero = (EditText)findViewById(R.id.editText4);

        botao.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {

                if(numero.length() !=12) {

                    Toast.makeText(getApplicationContext(), "Cadastro de numero invalido! digite (ddd)xxxxxxxxx ", Toast.LENGTH_SHORT).show();

                }

                else
                {
                    BancoController crud = new BancoController(getBaseContext());

                    String numeroString = numero.getText().toString();
                    String result;

                    result = crud.InsereDado(numeroString);

                    Toast.makeText(getApplicationContext(), "numero cadastrado", Toast.LENGTH_LONG).show();
                    finish();
                }

            }

        });


    }

}
