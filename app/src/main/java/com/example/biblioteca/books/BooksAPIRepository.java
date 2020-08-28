package com.example.biblioteca.books;

import android.util.Log;

import com.example.biblioteca.apihttp.APIService;
import com.example.biblioteca.apihttp.pojos.ResponseBooksAPI;
import com.example.biblioteca.root.App;
import com.example.biblioteca.root.DaggerApplicationComponent;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksAPIRepository extends App implements BooksRepository{

    @Inject
    APIService apiService;

    public BooksAPIRepository() {
        DaggerApplicationComponent.builder().build().inject(this);
    }

    @Override
    public void getBooksList(String search, BooksViewModel.CustomCallback callback) {
            apiService.getBooksList(search).enqueue(new Callback<ResponseBooksAPI>() {
                @Override
                public void onResponse(Call<ResponseBooksAPI> call, Response<ResponseBooksAPI> response) {
                   if(response.isSuccessful()){
                       callback.onSucess(response.body().getBooks());
                   }else{
                       callback.onFailure();
                   }
                }

                @Override
                public void onFailure(Call<ResponseBooksAPI> call, Throwable t) {
                    callback.onFailure();
                }
            });
    }
}
