package com.example.biblioteca.root;

import com.example.biblioteca.apihttp.APIModule;
import com.example.biblioteca.books.BooksAPIRepository;
import com.example.biblioteca.books.BooksActivity;
import com.example.biblioteca.books.BooksModule;
import com.example.biblioteca.books.BooksViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, APIModule.class, BooksModule.class})
public interface ApplicationComponent {

    void inject(BooksAPIRepository booksAPIRepository);
    void inject(BooksViewModel booksViewModel);
    void inject(BooksActivity booksActivity);
}
