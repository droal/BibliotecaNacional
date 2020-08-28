package com.example.biblioteca.books;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.biblioteca.R;
import com.example.biblioteca.apihttp.pojos.Book;
import com.example.biblioteca.databinding.ActivityBookDetailBinding;

import retrofit2.http.Url;

public class BookDetailActivity extends AppCompatActivity {

    private ActivityBookDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBookDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Book book = (Book) getIntent().getSerializableExtra("book_delected");

         /*Glide.with(this)
                .load(book.getImage())
                .error(R.drawable.books)
                .into(binding.ivImageBook);*/

         binding.pbBookDetail.setVisibility(View.VISIBLE);


         Glide.with(this)
                 .load(book.getImage())
                 .listener(new RequestListener<Drawable>() {
                     @Override
                     public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                         binding.pbBookDetail.setVisibility(View.GONE);
                         return false;
                     }

                     @Override
                     public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                         binding.pbBookDetail.setVisibility(View.GONE);
                         binding.tvTitle.setText(book.getTitle());
                         binding.tvSubtitle.setText(book.getSubtitle());
                         binding.tvIsbn.setText(book.getIsbn13());
                         binding.tvPrice.setText(book.getPrice());
                         return false;
                     }
                 })
                 .into(binding.ivImageBook);


    }
}