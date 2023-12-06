package com.example.docvet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

        Button btnCadastrar = findViewById(R.id.btnCadastrarDonoDePet);
        EditText edtNome = findViewById(R.id.edtNomeDonoPet);
        EditText edtEmail = findViewById(R.id.edtEmailDonoPet);
        EditText edtCpf = findViewById(R.id.edtCpfDonoPet);
        EditText edtTelefone = findViewById(R.id.edtTelefoneDonoPet);
        EditText edtSenha = findViewById(R.id.edtSenhaDonoPet);
        EditText edtConfSenha = findViewById(R.id.edtConfSenhaDonoPet);

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

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(cpf) || TextUtils.isEmpty(telefone)
                    || TextUtils.isEmpty(senha) || TextUtils.isEmpty(confSenha)) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else if (!senha.equals(confSenha)) {
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
            } else {
                // Cadastro realizado com sucesso
                Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();

                Pessoa pessoa = new Pessoa(
                        edtNome.getText().toString(),
                        email,
                        cpf,
                        telefone,
                        senha,
                        confSenha);

                Call<Void> call = service.cadastrarUsuario(pessoa);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            // Sucesso na chamada à API
                            Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(CadastroActivity.this, CadastroPet.class);
                            startActivity(intent);
                            finish();  // Aqui termina a atividade após o cadastro ser realizado com sucesso
                        } else {
                            // Falha na chamada à API
                            Toast.makeText(CadastroActivity.this, "Erro ao cadastrar. Por favor, tente novamente.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        // Erro durante a chamada à API
                        Toast.makeText(CadastroActivity.this, "Erro ao cadastrar: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
