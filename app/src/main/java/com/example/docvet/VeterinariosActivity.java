package com.example.docvet;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

public class VeterinariosActivity extends AppCompatActivity {

    private ImageView logoVet;
    private Spinner filtrosVet;
    private EditText edtPesquisar;
    private ListView listVeterinarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinarios);

        // Inicializar elementos
        initViews();
    }

    private void initViews() {
        logoVet = findViewById(R.id.logoVet);
        filtrosVet = findViewById(R.id.filtrosVet);
        edtPesquisar = findViewById(R.id.edtPesquisar);
        listVeterinarios = findViewById(R.id.listVeterinarios);
    }
}
