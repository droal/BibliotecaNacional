package com.example.biblioteca.root;

import android.app.Application;

import com.example.biblioteca.apihttp.APIModule;
import com.example.biblioteca.books.BooksModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .aPIModule(new APIModule())
                .booksModule(new BooksModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
