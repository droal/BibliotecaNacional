package com.example.biblioteca.apihttp;

import com.example.biblioteca.apihttp.pojos.ResponseBooksAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("{query}")
    Call<ResponseBooksAPI> getBooksList(@Path("query") String query);
}
