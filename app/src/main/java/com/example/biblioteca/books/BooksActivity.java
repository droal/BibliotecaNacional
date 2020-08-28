package com.example.biblioteca.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.biblioteca.R;
import com.example.biblioteca.apihttp.APIService;
import com.example.biblioteca.apihttp.pojos.Book;
import com.example.biblioteca.databinding.ActivityBooksBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class BooksActivity extends AppCompatActivity {

    private BooksViewModel booksViewModel;
    private ActivityBooksBinding binding;
    private List<Book> booksList = new ArrayList<>();
    private BooksListAdapter adapter;

    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBooksBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Obtener viewModel
        booksViewModel = ViewModelProviders.of(this).get(BooksViewModel.class);

        //Configurar adapter
        adapter = new BooksListAdapter(booksList, this);
        binding.rvBooksList.setAdapter(adapter);
        binding.rvBooksList.setItemAnimator(new DefaultItemAnimator());
        binding.rvBooksList.setHasFixedSize(false);
        binding.rvBooksList.setLayoutManager(new LinearLayoutManager(this));

        //Inicalizar observador
        initObservers();

        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booksList.clear();
                adapter.notifyDataSetChanged();

                if(binding.etSearchInput.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), getString(R.string.search_imput_empty), Toast.LENGTH_SHORT).show();
                }
                else{
                    booksViewModel.getBooksList(binding.etSearchInput.getText().toString().trim());
                    binding.progressBar.setVisibility(View.VISIBLE);
                    binding.rvBooksList.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    private void initObservers() {
        booksViewModel.getObseervable().observe(this, books -> {

            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.rvBooksList.setVisibility(View.VISIBLE);

            if(books != null  && books.size()>0){
                    booksList.clear();
                    booksList.addAll(books);
                    adapter.notifyDataSetChanged();
            }else{
                Toast.makeText(this, getString(R.string.booklist_empty), Toast.LENGTH_SHORT).show();
            }
        });
    }

}