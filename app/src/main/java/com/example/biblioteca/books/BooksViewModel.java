package com.example.biblioteca.books;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.biblioteca.apihttp.pojos.Book;
import com.example.biblioteca.root.DaggerApplicationComponent;

import java.util.List;

import javax.inject.Inject;

public class BooksViewModel extends ViewModel {

    @Inject
    BooksRepository booksRepository;

    private MutableLiveData<List<Book>> booksListMutable = null;

    public BooksViewModel() {
        DaggerApplicationComponent.builder().build().inject(this);
    }


    public interface CustomCallback {
        void onSucess(List<Book> booksList);
        void onFailure();
    }


    public LiveData<List<Book>> getObseervable(){
        if(booksListMutable == null){
            booksListMutable = new MutableLiveData<>();
        }
        return booksListMutable;
    }


    public void getBooksList(String search){
        booksRepository.getBooksList(search, new CustomCallback(){

            @Override
            public void onSucess(List<Book> booksList) {
                booksListMutable.setValue(booksList);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}
