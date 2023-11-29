package com.example.docvet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.docvet.model.Pessoa;
import com.example.docvet.services.PessoaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CadastroActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private PessoaService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        EditText edtNome = findViewById(R.id.edtNome);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtCpf = findViewById(R.id.edtCpf);
        EditText edtTelefone = findViewById(R.id.edtTelefone);
        EditText edtSenha = findViewById(R.id.edtSenha);
        EditText edtConfSenha = findViewById(R.id.edtConfSenha);

        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.56.1:8080/pessoa/") // ipv4 do pc
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(PessoaService.class);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro de comunicação: Verifique sua conexão com a Internet", Toast.LENGTH_SHORT).show();
            return; // Saia do método se houver um erro na configuração do Retrofit
        }

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

                Pessoa pessoa = new Pessoa(
                        edtNome.getText().toString(),
                        edtEmail.getText().toString(),
                        edtCpf.getText().toString(),
                        edtTelefone.getText().toString(),
                        edtSenha.getText().toString(),
                        edtConfSenha.getText().toString());

                Call<Void> call = service.cadastrarUsuario(pessoa);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();  // Aqui termina a atividade após o cadastro ser realizado com sucesso
                        } else {
                            Toast.makeText(CadastroActivity.this, "Erro durante o cadastro", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(CadastroActivity.this, "Erro durante o cadastro: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
