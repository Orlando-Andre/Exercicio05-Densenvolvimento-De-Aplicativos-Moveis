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

import java.util.Random;

public class Codificador extends AppCompatActivity {

    EditText mensagem;
    TextView mensagemCodificada, mensagemDecodificada;
    ImageView btnCodificar, btnDecodificar, btnVoltar;

    int numeroAleatorio = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.codificador);

        mensagem = findViewById(R.id.edtCodificar);
        mensagemCodificada = findViewById(R.id.txtMensagemCodificada);
        mensagemDecodificada = findViewById(R.id.txtMensagemDecodificada);
        btnCodificar = findViewById(R.id.btnCodificar);
        btnDecodificar = findViewById(R.id.btnDecodificar);
        btnVoltar = findViewById(R.id.btnVoltar);

        mensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensagem.setText("");
                mensagemCodificada.setText("");
                mensagemDecodificada.setText("");
                numeroAleatorio = 0;
            }
        });


        btnCodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mensagem.getText().toString().isEmpty()) {

                    //Gera um número de 0 a 25 e adiciona 1;
                    Random random = new Random();
                    numeroAleatorio = random.nextInt(26)+1;

                    //Chama o método cifra que codifica a mensagem
                    String msgCodificada = cifrar(mensagem.getText().toString(), numeroAleatorio);

                    mensagemCodificada.setText(msgCodificada);

                } else{
                    Toast.makeText(Codificador.this, "Campos não podem ser nulos!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnDecodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mensagemCodificada.getText().toString().isEmpty()){

                    String msgDecodificada = decifrar(mensagemCodificada.getText().toString(), numeroAleatorio);

                    mensagemDecodificada.setText(msgDecodificada);

                }else{
                    Toast.makeText(Codificador.this, "Não há nenhuma mensagem codificada!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Codificador.this, SecondActivity.class);
                startActivity(i);
                finish();
            }
        });
    }


    public static String cifrar(String mensagem, int chave) {

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < mensagem.length(); i++) {
            char caracter = mensagem.charAt(i);

            //Verifica se o caracter é uma letra
            if (Character.isLetter(caracter)) {

                //Aloca na variavél base o referencial do alfabeto, ou seja testa se a letra é maiúscula ou minúscula e aloca.
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';

                /*Fórmula da cifragem - Ex: se caracter for 'D' e base for 'A', então caracter - base seria igual a 3, pois 'D' está três posições após 'A' no alfabeto.
                adicionamos a chave de cifragem ao deslocamento calculado. Isso nos dá um novo valor que representa a letra deslocada no alfabeto.
                O operador % 26 garante que, se o valor resultante exceder 26 (o número de letras no alfabeto), ele será mantido dentro do intervalo de 0 a 25.
                adicionamos base ao resultado para trazer o valor de volta ao alfabeto original (maiúsculo ou minúsculo)*/
                caracter = (char) (((caracter - base + chave) % 26) + base);

            }
            resultado.append(caracter);
        }
        return resultado.toString();
    }

    public static String decifrar(String mensagemCifrada, int chave) {
        return cifrar(mensagemCifrada, 26 - chave); // Decifragem é a cifragem com chave inversa
    }
}
