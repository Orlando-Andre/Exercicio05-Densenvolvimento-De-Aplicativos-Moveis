package com.example.exercicio05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;


public class RandomizadorPalavras extends AppCompatActivity {

    EditText palavra;
    TextView palavraEscolhida;

    ImageView btnAdicionar, btnSortear, btnVoltar;

    ItemAdapterRandomizador adapter;
    RecyclerView recyclerView;

    ArrayList<String> palavras;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randomizador_palavras);


        palavra = findViewById(R.id.edtTexto);
        palavraEscolhida = findViewById(R.id.txtPalavraEscolhida);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnSortear = findViewById(R.id.btnSortear);
        btnVoltar = findViewById(R.id.btnVoltar);

        recyclerView = findViewById(R.id.recycler);

        palavras = new ArrayList<>();

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!palavra.getText().toString().isEmpty()) {

                    palavras.add(palavra.getText().toString());
                    palavra.setText("");

                    adapter = new ItemAdapterRandomizador(RandomizadorPalavras.this, palavras);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(RandomizadorPalavras.this));
                    recyclerView.setAdapter(adapter);

                }else {
                    Toast.makeText(RandomizadorPalavras.this, "Campo vazio!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!palavras.isEmpty()){

                    Random random = new Random();
                    int index = random.nextInt(palavras.size());
                    palavraEscolhida.setText(palavras.get(index).toString());

                }else{
                    Toast.makeText(RandomizadorPalavras.this, "Adicione palavras à lista!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RandomizadorPalavras.this, SecondActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}
