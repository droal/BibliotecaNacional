package com.example.biblioteca.books;

public interface BooksRepository {

    void getBooksList(String search, BooksViewModel.CustomCallback callback);
}
