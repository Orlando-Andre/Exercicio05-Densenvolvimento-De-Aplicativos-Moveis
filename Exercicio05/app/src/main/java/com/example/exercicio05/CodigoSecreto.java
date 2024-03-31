package com.example.exercicio05;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
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

public class CodigoSecreto extends AppCompatActivity {

    EditText alternativa01, alternativa02, alternativa03, alternativa04;
    TextView txtResultado01, txtResultado02, txtResultado03, txtResultado04;

    ImageView btnAdicionar, btnVoltar;

    ItemAdapterCodigoSecreto adapter;
    RecyclerView recyclerView;

    ArrayList<AlternativasCodigoSecreto> valores;

    int valorGerado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.codigo_secreto);

        // dados digitados pelo usuário
        alternativa01 = findViewById(R.id.edt01);
        alternativa02 = findViewById(R.id.edt02);
        alternativa03 = findViewById(R.id.edt03);
        alternativa04 = findViewById(R.id.edt04);

        //Campos onde aparecerão as mensagens
        txtResultado01 = findViewById(R.id.txt01);
        txtResultado02 = findViewById(R.id.txt02);
        txtResultado03 = findViewById(R.id.txt03);
        txtResultado04 = findViewById(R.id.txt04);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        recyclerView = findViewById(R.id.recycler);

         ArrayList<AlternativasCodigoSecreto> valores = new ArrayList<>();

        //Gerar um número aleatório
        //Gera um número de 0 a 8999 e adiciona 1000;
        Random random = new Random();
        valorGerado = random.nextInt(9000) + 1000;

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(alternativa01.getText().toString().isEmpty() ||
                        alternativa02.getText().toString().isEmpty() ||
                        alternativa03.getText().toString().isEmpty() ||
                        alternativa04.getText().toString().isEmpty())) {

                    //converte os dados pra inteiro
                    int alt01 = Integer.parseInt(alternativa01.getText().toString());
                    int alt02 = Integer.parseInt(alternativa02.getText().toString());
                    int alt03 = Integer.parseInt(alternativa03.getText().toString());
                    int alt04 = Integer.parseInt(alternativa04.getText().toString());

                    if (!((alt01 > 9 || alt01 < 0) ||
                            (alt02 > 9 || alt02 < 0) ||
                            (alt03 > 9 || alt03 < 0) ||
                            (alt04 > 9 || alt04 < 0))) {


                        //Adicionar na ArrayList
                        valores.add(new AlternativasCodigoSecreto(alt01,alt02,alt03,alt04));

                        //Aloca os dados na recycler view
                        adapter = new ItemAdapterCodigoSecreto(CodigoSecreto.this, valores);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(CodigoSecreto.this));
                        recyclerView.setAdapter(adapter);

                        //testar se os valores são iguais aos gerados
                        testarValores(valorGerado, alt01, alt02, alt03, alt04, valores.size());


                    }else {
                        Toast.makeText(CodigoSecreto.this, "Os campos devem ser > 0 ou < que 9!", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(CodigoSecreto.this, "Os campos não podem ser nulos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CodigoSecreto.this, SecondActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void testarValores(int valorGerado , int v01, int v02, int v03, int v04 , int qtdTentativas) {

        int digito1 = valorGerado / 1000;
        int digito2 = (valorGerado / 100) % 10;
        int digito3 = (valorGerado / 10) % 10;
        int digito4 = valorGerado % 10;

        //Testo se o valor gerado é o mesmo número digitado pelo usuário
        if (digito1 == v01 && digito2 == v02 && digito3 == v03 && digito4 == v04) {

            //Acertou !!!!

            //Criar intent e mandar dados
            Intent i = new Intent(CodigoSecreto.this, SucessoCodigoSecreto.class);
            i.putExtra("qtdTentativas" , qtdTentativas);
            startActivity(i);
            finish();

        }else {
            if (digito1 == v01) {
                // certo na posição
                txtResultado01.setText("Certo na posição");
            } else {
                if (digito2 == v01 || digito3 == v01 || digito4 == v01) {
                    //certo
                    txtResultado01.setText("Certo");
                } else {
                    //errado
                    txtResultado01.setText("Errado");
                }
            }

            if (digito2 == v02) {
                //certo na posição
                txtResultado02.setText("Certo na posição");
            } else {
                if (digito1 == v02 || digito3 == v02 || digito4 == v02) {
                    //certo
                    txtResultado02.setText("Certo");
                } else {
                    txtResultado02.setText("Errado");
                }
            }

            if (digito3 == v03) {
                // certo na posição
                txtResultado03.setText("Certo na posição");
            } else {
                if (digito1 == v03 || digito2 == v03 || digito4 == v03) {
                    //certo
                    txtResultado03.setText("Certo");
                } else {
                    txtResultado03.setText("Errado");
                }
            }

            if (digito4 == v04) {
                // certo na posição
                txtResultado04.setText("Certo na posição");
            } else {
                if (digito1 == v04 || digito2 == v04 || digito3 == v04) {
                    //certo
                    txtResultado04.setText("Certo");
                } else {
                    txtResultado04.setText("Errado");
                }
            }
        }
    }


}
