package com.example.nicolas.moreaqui;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private Button btnPronto;
    private EditText etFone;
    private RadioButton rbPq, rbMd, rbGrd, rbNsTam, rbCasa, rbAp, rbLoja, rbNsTipo;
    private RadioGroup rg1, rg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        rg2 = (RadioGroup) findViewById(R.id.rg2);
        btnPronto = (Button) findViewById(R.id.btnPronto);
        etFone = (EditText) findViewById(R.id.etFone);
        btnPronto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!isInt (etFone.getText().toString())) {
                    etFone.setText("");
                    etFone.setHint("");
                    etFone.setHint("NUMERO INVALIDO");
                    return;
                }
                switch (rg1.getCheckedRadioButtonId()) {
                    case R.id.rbPq:
                        break;
                    case R.id.rbMd:
                        break;
                    case R.id.rbGrd:
                        break;
                    case R.id.rbNsTam:
                        break;
                    default:
                        AlertDialog.Builder mensagem = new AlertDialog.Builder(InsertActivity.this);
                        mensagem.setTitle("Atenção");
                        mensagem.setMessage("Favor Selecionar Tamanho");
                        mensagem.setNeutralButton("OK", null);
                        mensagem.show();
                    return;
                }
                switch (rg2.getCheckedRadioButtonId()) {
                    case R.id.rbCasa:
                        break;
                    case R.id.rbAp:
                        break;
                    case R.id.rbLoja:
                        break;
                    case R.id.rbNsTipo:
                        break;
                    default:
                        AlertDialog.Builder mensagem = new AlertDialog.Builder(InsertActivity.this);
                        mensagem.setTitle("Atenção");
                        mensagem.setMessage("Favor Selecionar Tipo");
                        mensagem.setNeutralButton("OK", null);
                        mensagem.show();
                        return;
                }
                Intent it = new Intent(InsertActivity.this, MoreAquiActivity.class);
                startActivity(it);
                Toast.makeText(getApplicationContext(), "Dados Salvos.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean isInt(String str) {
        boolean isInteger = true;
        try {
            int i = Integer.parseInt(str);
        } catch(NumberFormatException nfe) {
            isInteger = false;
        }
        return isInteger;
    }
}
