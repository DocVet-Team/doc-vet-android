package com.example.docvet.services;

import com.example.docvet.model.Pessoa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PessoaService {

    @Headers("Accept: /api/v1/pessoas")
    @POST("/")
    Call<Pessoa> postPessoa(@Body Pessoa pessoa);

    @Headers("Accept: /api/v1/pessoas")
    @GET("/")
    Call<List<Pessoa>> getPessoa();

    @POST("/api/v1/pessoas/")
    Call<Void> cadastrarUsuario(@Body Pessoa pessoa);
}
