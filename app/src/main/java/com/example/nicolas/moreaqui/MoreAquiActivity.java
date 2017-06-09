package com.example.nicolas.moreaqui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MoreAquiActivity extends AppCompatActivity {
    private Button btnNovo;
    private Button btnProcurar;
    private Button btnMapa;
    private  CriaBanco banco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_aqui);
        btnNovo = (Button) findViewById(R.id.btnNovo);
        btnProcurar = (Button) findViewById(R.id.btnProcurar);
        btnMapa = (Button) findViewById(R.id.btnMapa);

        btnNovo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MoreAquiActivity.this, InsertActivity.class);
                startActivity(it);
            }
        });
        btnProcurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btpesquisarOnClick(v);
            }
        });
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Não Implementado Ainda.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btpesquisarOnClick(View v) {
        final EditText etCodPesquisa = new EditText(getApplicationContext());
        etCodPesquisa.setTextColor(Color.BLACK);

        AlertDialog.Builder telaPesquisa = new AlertDialog.Builder(this);
        telaPesquisa.setTitle("Pesquisa");
        telaPesquisa.setMessage("Informe o código para pesquisa");
        telaPesquisa.setView(etCodPesquisa);
        telaPesquisa.setNegativeButton("Cancelar", null);
        telaPesquisa.setPositiveButton("Pesquisar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                realizarPesquisa(Integer.parseInt(etCodPesquisa.getText().toString()));
            }
        });

        telaPesquisa.show();
    }
    protected void realizarPesquisa(int id){
        banco = new CriaBanco(getApplicationContext());
        Dados dados = banco.pesquisarRegistro(id);

        if(dados != null){
            Intent intent = new Intent(this, InsertActivity.class);
            intent.putExtra("",String.valueOf(dados.get_id()));
            intent.putExtra("num_fone",String.valueOf(dados.getNum_fone()));
            intent.putExtra("tip",dados.getTipo());
            intent.putExtra("tam",dados.getTamanho());
            startActivity(intent);

            Toast.makeText(getApplicationContext(),"Registro encontrado", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Registro não encontrado", Toast.LENGTH_SHORT).show();
        }
    }
}

