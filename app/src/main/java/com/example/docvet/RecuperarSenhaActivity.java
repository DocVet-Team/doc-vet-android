package com.example.docvet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecuperarSenhaActivity extends AppCompatActivity {

    private EditText edtSenha, edtConfSenha, edtEmailrs;
    private Button btnSalvarNovaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        // Inicializar elementos
        initViews();

        btnSalvarNovaSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCadastro();
            }
        });
    }

    private void initViews() {
        edtEmailrs = findViewById(R.id.edtEmailDonoPet);
        edtSenha = findViewById(R.id.edtSenhaDonoPet);
        edtConfSenha = findViewById(R.id.edtConfSenhaDonoPet);
        btnSalvarNovaSenha = findViewById(R.id.btnSalvarNovaSenha);
    }

    private void validarCadastro() {
        String senha = edtSenha.getText().toString();
        String confSenha = edtConfSenha.getText().toString();

        if (senha.isEmpty() || confSenha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        } else if (!senha.equals(confSenha)) {
            Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Recuperação de senha realizada com sucesso", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}