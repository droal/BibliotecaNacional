package com.example.biblioteca.apihttp.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseBooksAPI {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("books")
    @Expose
    private List<Book> books = null;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}