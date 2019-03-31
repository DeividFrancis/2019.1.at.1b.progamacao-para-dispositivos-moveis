package com.github.deividfrancis.at1badelcio;

import android.os.Bundle;
import android.widget.TextView;

import com.github.deividfrancis.at1badelcio.core.AppCompatActivityDefault;

public class Tela03 extends AppCompatActivityDefault {


    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela03);

        getSupportActionBar().setTitle("Tela 03");

        txt = findViewById(R.id.txt);
        txt.setText("Bem vindo a tela 03, Caso queira mudar esta mensagem vá ate a tela 02 e digite algo.");

        loadBundle();
    }


    private void loadBundle(){
        Bundle bundle = getIntent().getExtras();

        if(bundle == null) return;

        if(bundle.containsKey("edtMensagem")){
            txt.setText(bundle.getString("edtMensagem"));
        }
    }
}
