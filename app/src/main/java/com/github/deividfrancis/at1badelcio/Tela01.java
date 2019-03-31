package com.github.deividfrancis.at1badelcio;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.deividfrancis.at1badelcio.core.AppCompatActivityDefault;

public class Tela01 extends AppCompatActivityDefault {

    private ImageView img;
    public static final String TAG = "evento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela01);
        Log.i(TAG, "Estou passando pelo evento OnCreate");

        getSupportActionBar().setTitle("Tela 01");

        // Pega componente da imagem view
        img = findViewById(R.id.img);
    }


    public void onClick(View view) {

        int imgId = 0;
        String toastMsg = "Não foi encontrado a imagem";

        switch (view.getId()) {
            case R.id.btnImg01:
                imgId = R.drawable.eu;
                toastMsg = "Meu deos do céu so quero que o semestre acabe";
                break;
            case R.id.btnImg02:
                imgId = R.drawable.bruno;
                toastMsg = "Ele quase não fala";
                break;
        }

        if (imgId != 0)
            img.setImageResource(imgId);

        Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Estou passando pelo evento OnResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Estou passando pelo evento OnStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Estou passando pelo evento OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Estou passando pelo evento OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Estou passando pelo codigo OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Estou passando pelo metodo OnDestroy");
    }
}
