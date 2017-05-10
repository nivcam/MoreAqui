package com.example.nicolas.moreaqui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoreAquiActivity extends AppCompatActivity {
    private Button btnNovo;
    private Button btnProcurar;
    private Button btnMapa;


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
    }
}

