package com.example.docvet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtCpf = findViewById(R.id.edtCpf);
        EditText edtTelefone = findViewById(R.id.edtTelefone);
        EditText edtSenha = findViewById(R.id.edtSenha);
        EditText edtConfSenha = findViewById(R.id.edtConfSenha);

        btnCadastrar.setOnClickListener(v -> {
            String email = edtEmail.getText().toString();
            String cpf = edtCpf.getText().toString();
            String telefone = edtTelefone.getText().toString();
            String senha = edtSenha.getText().toString();
            String confSenha = edtConfSenha.getText().toString();

            if (email.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || senha.isEmpty() || confSenha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else if (!senha.equals(confSenha)) {
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
