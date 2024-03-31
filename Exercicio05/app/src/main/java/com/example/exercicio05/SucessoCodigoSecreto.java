package com.example.exercicio05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SucessoCodigoSecreto extends AppCompatActivity {

    TextView qtdTentativas;

    ImageView btnVoltar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sucesso_codigo_secreto);

        qtdTentativas = findViewById(R.id.qtdTentativas);
        btnVoltar = findViewById(R.id.btnVoltar);

        //Dados vindos da Intent
        Intent telaAnterior = getIntent();
        int qtd = telaAnterior.getIntExtra("qtdTentativas", 0);

        qtdTentativas.setText(Integer.toString(qtd));



        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SucessoCodigoSecreto.this, SecondActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
