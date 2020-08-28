package com.example.biblioteca.books;

import dagger.Module;
import dagger.Provides;

@Module
public class BooksModule {

    @Provides
    public BooksRepository provideBooksRepository(){
        return new BooksAPIRepository();
    }
}
