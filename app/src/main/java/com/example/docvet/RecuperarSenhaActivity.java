package com.example.docvet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecuperarSenhaActivity extends AppCompatActivity {

    private EditText edtSenha, edtConfSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        // Inicializar elementos
        initViews();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCadastro();
            }
        });
    }

    private void initViews() {
        edtSenha = findViewById(R.id.edtSenha);
        edtConfSenha = findViewById(R.id.edtConfSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);
    }

    private void validarCadastro() {
        String senha = edtSenha.getText().toString();
        String confSenha = edtConfSenha.getText().toString();

        if (senha.isEmpty() || confSenha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        } else if (!senha.equals(confSenha)) {
            Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
        } else {
            // Simulação de ação após o cadastro (substitua com sua lógica real)
            Toast.makeText(this, "Recuperação de senha realizada com sucesso", Toast.LENGTH_SHORT).show();

            // Navegue para a próxima tela ou realize outra ação conforme necessário
            // Exemplo: startActivity(new Intent(this, ProximaActivity.class));
        }
    }
}