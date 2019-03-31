package com.github.deividfrancis.at1badelcio.core;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.deividfrancis.at1badelcio.R;

public class AppCompatActivityDefault extends AppCompatActivity {
    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Setar na tela
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String text = null;
        switch (item.getItemId()) {
            case R.id.item_voltar:
                text = "Vou voltar";
                break;
            case R.id.item_sair:
                alertDialogExit();
                break;
        }
        if(text != null)
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }

    private void alertDialogExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja realmente sair do app?");
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        final Context obj = this;
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText( obj, "Uffa!", Toast.LENGTH_LONG).show();
            }
        });

        builder.show();
    }
}

