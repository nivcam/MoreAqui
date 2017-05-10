package com.example.nicolas.moreaqui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private Button btnPronto;
    private EditText etFone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        btnPronto = (Button) findViewById(R.id.btnPronto);
        etFone = (EditText) findViewById(R.id.etFone);
        btnPronto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!isInt (etFone.getText().toString())) {
                    etFone.setText("");
                    etFone.setHint("NUMERO INVALIDO");
                    return;
                };

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
