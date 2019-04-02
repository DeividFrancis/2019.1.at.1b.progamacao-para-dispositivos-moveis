package com.github.deividfrancis.at1badelcio;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.MaskFilter;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.deividfrancis.at1badelcio.core.AppCompatActivityDefault;

public class Tela03 extends AppCompatActivityDefault {


    TextView txt;
    EditText edtText;
    int radioId;
    ConstraintLayout formLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela03);

        getSupportActionBar().setTitle("Tela 03");

        txt = findViewById(R.id.txt);
        txt.setText("Bem vindo a tela 03, Caso queira mudar esta mensagem vá ate a tela 02 e digite algo.");

        edtText = findViewById(R.id.edtTxt);
        formLayout = findViewById(R.id.formLayoutId);
        formLayout.setVisibility(View.INVISIBLE);

        loadBundle();
    }

    public void onCheck(View view) {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioId = radioGroup.getCheckedRadioButtonId();

        boolean isChecked = ((RadioButton) view).isChecked();
        if (isChecked) {
            formLayout.setVisibility(View.VISIBLE);
        }

        switch (radioId) {
            case R.id.radioWeb:
                edtText.setHint("Digite uma pesquisa");
                edtText.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case R.id.radioPhone:
                edtText.setHint("Digite um telefone");
                edtText.setInputType(InputType.TYPE_CLASS_PHONE);
                break;
            case R.id.radioMaps:
                edtText.setHint("Digite um endereço");
                edtText.setInputType(InputType.TYPE_CLASS_TEXT);
                break;

        }
    }

    public void onClick(View view) {

        String edtTextStr = edtText.getText().toString();
        String msg = null;
        String uriText = null;
        String itAction = null;
        Intent intent = new Intent();

        switch (view.getId()) {
            case R.id.btnEnviar:
                switch (radioId) {
                    case R.id.radioWeb:
                        itAction = Intent.ACTION_VIEW;
                        uriText = "https://www.google.com/search?q=" + edtTextStr;
                        break;
                    case R.id.radioPhone:
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            msg = "Você não tem permição boco!";
                            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                            return;
                        }
                        itAction = Intent.ACTION_CALL;
                        uriText = "tel:" + edtTextStr.replaceAll("[^0-9]", "");
                        break;
                    case R.id.radioMaps:
                        itAction = Intent.ACTION_VIEW;
                        intent.setPackage("com.google.android.maps");
                        uriText = "geo:0,0?q=" + edtTextStr;
                        break;
                    default:
                        msg = "Selecione uma opção antes de clicar!";
                        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                        return;

                }
                break;
        }

        intent = new Intent(itAction, Uri.parse(uriText));
        startActivity(intent);
    }

    private void loadBundle() {
        Bundle bundle = getIntent().getExtras();

        if (bundle == null) return;

        if (bundle.containsKey("edtMensagem")) {
            txt.setText(bundle.getString("edtMensagem"));
        }
    }
}
