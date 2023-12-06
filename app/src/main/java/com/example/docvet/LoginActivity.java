package com.example.docvet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private View view;
    private ImageView imgLogo, imgPatinhas1, imgPatinhas2, imgPatinhas3, imgPatinhas4;
    private TextView txtLogin, txtvEsqSenha, txtvCriarConta, txtvCriarConta2;
    private EditText edtEmail, edtSenha;
    private Button btnEntrar, btnDepois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar elementos
        initViews();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, VeterinariosActivity.class);
                startActivity(intent);
            }
        });

        txtvCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        txtvCriarConta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroVeterinario.class);
                startActivity(intent);
            }
        });


        txtvEsqSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RecuperarSenhaActivity.class);
                startActivity(intent);
            }
        });

        btnDepois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, VeterinariosActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        view = findViewById(R.id.view);
        imgLogo = findViewById(R.id.ImgLogo);
        imgPatinhas1 = findViewById(R.id.imageView);
        imgPatinhas2 = findViewById(R.id.imageView2);
        imgPatinhas3 = findViewById(R.id.imageView3);
        imgPatinhas4 = findViewById(R.id.imageView4);
        txtLogin = findViewById(R.id.txtLogin);
        txtvEsqSenha = findViewById(R.id.txtvEsqSenha);
        Log.e("guilherme",txtvEsqSenha.getText().toString());
        txtvCriarConta = findViewById(R.id.txtvCriarConta);
        txtvCriarConta2 = findViewById(R.id.txtvCriarConta2);
        edtEmail = findViewById(R.id.edtEmailDonoPet);
        edtSenha = findViewById(R.id.edtCpfDonoPet);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnDepois = findViewById(R.id.btnDepois);
    }
}
