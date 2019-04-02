package com.github.deividfrancis.at1badelcio;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.deividfrancis.at1badelcio.core.AppCompatActivityDefault;

public class MainActivity extends AppCompatActivityDefault {


    private Button btn01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtSobre = findViewById(R.id.txtSobre);
        txtSobre.setText("At do 1 bimestre se SI, do profº Adelcio, com o objetivo de aplicar em pratica conteúdo mostrado em sala.");

    }



    public void onClick(View view) {

        Intent intent = null;
        String qualBtn = null;


        switch (view.getId()) {
            case R.id.btn01:
                intent = new Intent(this, Tela01.class);
                qualBtn = "Cliquei no botão 01";
                break;
            case R.id.btn02:
                intent = new Intent(this, Tela02.class);
                qualBtn = "Cliquei no botão 02";
                break;
            case R.id.btn03:
                intent = new Intent(this, Tela03.class);
                qualBtn = "Cliquei no botão 03";
                break;
        }

        startActivity(intent);
        Log.d("qualBtn", qualBtn);
//        finish();

    }
}
