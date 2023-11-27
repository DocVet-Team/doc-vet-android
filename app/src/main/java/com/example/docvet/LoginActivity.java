package com.example.docvet;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    private View view;
    private ImageView imgLogo, imgPatinhas1, imgPatinhas2, imgPatinhas3, imgPatinhas4;
    private TextView txtLogin, txtvEsqSenha, txtvCriarConta;
    private EditText edtEmail, edtSenha;
    private Button btnEntrar, btnDepois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar elementos
        initViews();

        btnDepois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, NavBarActivity.class);
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
        txtvCriarConta = findViewById(R.id.txtvCriarConta);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtCpf);
        btnEntrar = findViewById(R.id.btnCadastrar);
        btnDepois = findViewById(R.id.btnDepois);
    }

}
