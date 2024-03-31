package com.example.exercicio05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapterCodigoSecreto extends RecyclerView.Adapter<ItemAdapterCodigoSecreto.ViewHolder> {
    Context contexto;
    ArrayList<AlternativasCodigoSecreto> valores;

    public ItemAdapterCodigoSecreto(Context contexto, ArrayList<AlternativasCodigoSecreto> valores) {
        this.contexto = contexto;
        this.valores = valores;
    }

    @NonNull
    @Override
    public ItemAdapterCodigoSecreto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_view_codigo_secreto, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterCodigoSecreto.ViewHolder holder, int position) {
        holder.alternativa01.setText(Integer.toString(valores.get(position).getAlternativa01()));
        holder.alternativa02.setText(Integer.toString(valores.get(position).getAlternativa02()));
        holder.alternativa03.setText(Integer.toString(valores.get(position).getAlternativa03()));
        holder.alternativa04.setText(Integer.toString(valores.get(position).getAlternativa04()));
    }

    @Override
    public int getItemCount() { return valores.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView alternativa01 ,alternativa02, alternativa03, alternativa04;

        public ViewHolder(View itemView) {
            super(itemView);

            alternativa01 = itemView.findViewById(R.id.alt01);
            alternativa02 = itemView.findViewById(R.id.alt02);
            alternativa03 = itemView.findViewById(R.id.alt03);
            alternativa04 = itemView.findViewById(R.id.alt04);

        }

    }

}
