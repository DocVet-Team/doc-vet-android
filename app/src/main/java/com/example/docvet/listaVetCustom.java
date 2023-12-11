package com.example.docvet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.docvet.model.Veterinario;

import java.util.List;

public class listaVetCustom extends BaseAdapter {

    private LayoutInflater minInflater;
    private List lista;

    private ImageView imagemVet;
    private TextView txt1;
    private ImageView setaDireita;

    public listaVetCustom(Context context, List lista){
        this.lista = lista;
        minInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Object obj = lista.get(position);
        view = minInflater.inflate(R.layout.activity_lista_vet_custom, null);

        imagemVet = (ImageView) view.findViewById(R.id.imagem_lista);
        txt1 = (TextView) view.findViewById(R.id.titulo_lista);
        setaDireita = (ImageView) view.findViewById(R.id.seta_direita_lista);

        if (obj instanceof Veterinario){
//            try{
//                if (((Veterinario) obj).getFoto().isEmpty() || ((Veterinario) obj).getFoto() == null){
                    imagemVet.setImageResource(R.drawable.docvet);
//                }else {
//                    imagemVet.setImageURI(Uri.parse(((Veterinario) obj).getFoto()));
//                }
//            }catch (Exception e){
//                imagemVet.setImageResource(R.drawable.docvet_cinza);
//            }

            txt1.setText(((Veterinario) obj).getNome());
            //Seta para direita ficaria aqui
        }

        return view;
    }
}