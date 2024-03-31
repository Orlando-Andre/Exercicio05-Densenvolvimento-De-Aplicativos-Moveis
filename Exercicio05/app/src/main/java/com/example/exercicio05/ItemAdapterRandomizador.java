package com.example.exercicio05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapterRandomizador extends RecyclerView.Adapter<ItemAdapterRandomizador.ViewHolder> {

    Context contexto;
    ArrayList<String> palavras;

    public ItemAdapterRandomizador(Context contexto, ArrayList<String> palavras) {
        this.contexto = contexto;
        this.palavras = palavras;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_view_randomizador, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.palavra.setText(palavras.get(position));
    }

    @Override
    public int getItemCount() { return palavras.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView palavra;

        public ViewHolder(View itemView) {
            super(itemView);

            palavra = itemView.findViewById(R.id.palavra);

        }

    }

}
