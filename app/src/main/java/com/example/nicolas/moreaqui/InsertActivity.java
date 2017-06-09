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
    public int tipo;
    public  int tamanho;
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
        rbPq = (RadioButton) findViewById(R.id.rbPq);
        rbMd = (RadioButton) findViewById(R.id.rbMd);
        rbGrd = (RadioButton) findViewById(R.id.rbGrd);
        rbNsTam = (RadioButton) findViewById(R.id.rbNsTam);
        rbCasa = (RadioButton) findViewById(R.id.rbCasa);
        rbAp = (RadioButton) findViewById(R.id.rbAp);
        rbLoja = (RadioButton) findViewById(R.id.rbLoja);
        rbNsTipo = (RadioButton) findViewById(R.id.rbNsTipo);
        btnPronto = (Button) findViewById(R.id.btnPronto);
        etFone = (EditText) findViewById(R.id.etFone);

        Intent i = getIntent();
        String num_fone = i.getStringExtra("num_fone");
        int tip = i.getIntExtra("tip", -1);
        int tam = i.getIntExtra("tam", -1);
        etFone.setText(num_fone);
        if (tam == 1){
            rbPq.setChecked(true);
        }
        else if (tam == 2){
            rbMd.setChecked(true);
        }
        else if (tam == 3){
            rbGrd.setChecked(true);
        }
        else if (tam == 4){
            rbNsTam.setChecked(true);
        }

        if (tip == 1){
            rbCasa.setChecked(true);
        }
        else if (tip == 2){
            rbAp.setChecked(true);
        }
        else if (tip == 3){
            rbLoja.setChecked(true);
        }
        else if (tip == 4){
            rbNsTipo.setChecked(true);
        }

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
                        tamanho = 1;
                        break;
                    case R.id.rbMd:
                        tamanho = 2;
                        break;
                    case R.id.rbGrd:
                        tamanho = 3;
                        break;
                    case R.id.rbNsTam:
                        tamanho = 4;
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
                        tipo = 1;
                        break;
                    case R.id.rbAp:
                        tipo = 2;
                        break;
                    case R.id.rbLoja:
                        tipo = 3;
                        break;
                    case R.id.rbNsTipo:
                        tipo = 4;
                        break;
                    default:
                        AlertDialog.Builder mensagem = new AlertDialog.Builder(InsertActivity.this);
                        mensagem.setTitle("Atenção");
                        mensagem.setMessage("Favor Selecionar Tipo");
                        mensagem.setNeutralButton("OK", null);
                        mensagem.show();
                        return;
                }
                Dados xxx = new Dados();
                xxx.setNum_fone(Integer.parseInt(etFone.getText().toString()));
                xxx.setTipo(tipo);
                xxx.setTamanho(tamanho);
                CriaBanco kkk = new  CriaBanco(getApplicationContext());
                kkk.incluirRegistro(xxx);

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
