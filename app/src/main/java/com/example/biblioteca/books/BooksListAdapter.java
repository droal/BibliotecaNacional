package com.example.biblioteca.books;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biblioteca.R;
import com.example.biblioteca.apihttp.pojos.Book;
import com.example.biblioteca.databinding.ItemBooksListBinding;

import java.io.Serializable;
import java.util.List;

public class BooksListAdapter extends RecyclerView.Adapter<BooksListAdapter.ListItemViewHolder>{

    private List<Book> booksList;
    private Context context;

    public BooksListAdapter(List<Book> booksList,Context context) {
        this.booksList = booksList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBooksListBinding binding = ItemBooksListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ListItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
       holder.binding.itemTitle.setText(booksList.get(position).getTitle());
       holder.binding.itemImage.setImageResource(R.drawable.books);
       holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(context, BookDetailActivity.class);
               intent.putExtra("book_delected", (Serializable) booksList.get(position));
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return this.booksList.size();
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder{

        ItemBooksListBinding binding;

        public ListItemViewHolder(ItemBooksListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
