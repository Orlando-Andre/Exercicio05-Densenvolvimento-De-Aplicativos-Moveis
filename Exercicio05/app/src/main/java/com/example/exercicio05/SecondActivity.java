package com.example.exercicio05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        LinearLayout codificador, pedraPapelTesoura, codigoSecreto, randomizadorDePalavras;

        codificador = findViewById(R.id.codificador);
        pedraPapelTesoura = findViewById(R.id.pedraPapelTesoura);
        codigoSecreto = findViewById(R.id.codigoSecreto);
        randomizadorDePalavras = findViewById(R.id.randomizadorPalavras);

        codificador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SecondActivity.this, Codificador.class);
                startActivity(i);
                finish();

            }
        });

        pedraPapelTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SecondActivity.this, PedraPapelTesoura.class);
                startActivity(i);
                finish();

            }
        });

        codigoSecreto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SecondActivity.this, CodigoSecreto.class);
                startActivity(i);
                finish();

            }
        });

        randomizadorDePalavras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, RandomizadorPalavras.class);
                startActivity(i);
                finish();
            }
        });

    }
}
