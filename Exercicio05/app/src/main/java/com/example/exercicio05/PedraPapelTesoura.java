package com.example.exercicio05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PedraPapelTesoura extends AppCompatActivity {

    ImageView imgApp, imgPedra, imgPapel, imgTesoura , btnVoltar;
    TextView txtResultado;
    String escolhaApp, escolhaJogador;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedra_papel_tesoura);

        imgApp = findViewById(R.id.imgEscolhaApp);
        imgPedra = findViewById(R.id.imgPedra);
        imgPapel = findViewById(R.id.imgPapel);
        imgTesoura = findViewById(R.id.imgTesoura);

        txtResultado = findViewById(R.id.txtOpcoes);

        btnVoltar = findViewById(R.id.btnVoltar);


        imgPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               escolhaJogador = "pedra";
               escolhaApp =  escolhaDoApp();
               txtResultado.setText(calculaResultado(escolhaJogador,escolhaApp));


            }
        });

        imgPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                escolhaJogador = "papel";
                escolhaApp =  escolhaDoApp();
                txtResultado.setText(calculaResultado(escolhaJogador,escolhaApp));
            }
        });

        imgTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                escolhaJogador = "tesoura";
                escolhaApp =  escolhaDoApp();
                txtResultado.setText(calculaResultado(escolhaJogador,escolhaApp));

            }
        });



        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PedraPapelTesoura.this, SecondActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public String escolhaDoApp() {

        int numEscolhaDoApp;
        String escolhaDoApp;

        //Gera um número de 0 a 2 e adiciona 1;
        Random random = new Random();
        numEscolhaDoApp = random.nextInt(3) + 1;

        if (numEscolhaDoApp == 1){
            //pedra
            imgApp.setImageResource(R.drawable.pedra);
            escolhaDoApp = "pedra";
        }else{
            if (numEscolhaDoApp == 2){
                //papel
                imgApp.setImageResource(R.drawable.papel);
                escolhaDoApp = "papel";
            }else{
                //tesoura
                imgApp.setImageResource(R.drawable.tesoura);
                escolhaDoApp = "tesoura";
            }
        }

        return  escolhaDoApp;

    }

    public String calculaResultado(String escolhaJog , String escolhaApp) {

        String resultado;

        if (escolhaJog.equals(escolhaApp)){
            resultado = "empate!";
        } else {
            if((escolhaJog.equals("pedra") && escolhaApp.equals("tesoura")) || (escolhaJog.equals("papel") && escolhaApp.equals("pedra")) || (escolhaJog.equals("tesoura") && escolhaApp.equals("papel")) ){
                resultado = "Você ganhou!!! :)";
            } else{
                resultado = "Você perdeu :(";
            }
        }

        return resultado;
    }
}
