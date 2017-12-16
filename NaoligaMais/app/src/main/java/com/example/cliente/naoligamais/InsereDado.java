package com.example.cliente.naoligamais;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Cliente on 14/12/2017.
 */

public class InsereDado extends Activity {

    @Override
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);


        setContentView(R.layout.activity_block);


       Toast.makeText(getApplicationContext(), "deu aki",Toast.LENGTH_SHORT).show();






        Button botao = (Button)findViewById(R.id.salvar);

        final EditText numero = (EditText)findViewById(R.id.editText4);

        botao.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                BancoController crud = new BancoController(getBaseContext());

                String numeroString = numero.getText().toString();
                String result;

                result = crud.InsereDado(numeroString);

                Toast.makeText(getApplicationContext(), "foi", Toast.LENGTH_LONG).show();

            }

        });

    }

}
