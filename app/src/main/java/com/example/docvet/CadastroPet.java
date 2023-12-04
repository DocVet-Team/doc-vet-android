package com.example.docvet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CadastroPet extends AppCompatActivity implements View.OnClickListener {

    TextView edtDepois;
    EditText nome, raca, peso, tamanho, idade, foto;
    Spinner tipoAnimal;
    CheckBox portePequeno, porteMedio, porteGrande, sexoF, sexoM, castradoSim, castradoNao;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);

        nome.findViewById(R.id.edtNomePet);
        raca.findViewById(R.id.edtRaca);
        peso.findViewById(R.id.edtPeso);
        tamanho.findViewById(R.id.edtTamanho);
        idade.findViewById(R.id.edtIdadePet);
        foto.findViewById(R.id.edtFotoPet);

        tipoAnimal.findViewById(R.id.tipoAnimalSpinner);

        portePequeno.findViewById(R.id.checkPequeno);
        porteMedio.findViewById(R.id.checkMedio);
        porteGrande.findViewById(R.id.checkGrande);
        sexoF.findViewById(R.id.checkF);
        sexoM.findViewById(R.id.checkM);
        castradoSim.findViewById(R.id.checkSim);
        castradoNao.findViewById(R.id.checkNao);

        btnCadastrar.findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(this);

        edtDepois.findViewById(R.id.btnDepois);
    }


    @Override
    public void onClick(View view) {

    }
}