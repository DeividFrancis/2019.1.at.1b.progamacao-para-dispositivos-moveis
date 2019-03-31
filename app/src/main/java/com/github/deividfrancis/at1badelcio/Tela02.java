package com.github.deividfrancis.at1badelcio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.deividfrancis.at1badelcio.core.AppCompatActivityDefault;

import java.util.Objects;

public class Tela02 extends AppCompatActivityDefault {

    EditText edtMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela02);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Tela 02");


        edtMensagem = findViewById(R.id.edtMensagem);
    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnEnviar:
                String mensagem = edtMensagem.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("edtMensagem", mensagem);

                Intent intent = new Intent(this, Tela03.class);
                intent.putExtras(bundle);
                startActivity(intent);

                finish();
                break;
        }
    }
}
