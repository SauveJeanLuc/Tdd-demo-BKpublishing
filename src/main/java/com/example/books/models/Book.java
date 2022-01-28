package com.example.books.models;

import org.springframework.data.annotation.Id;

public class Book {
    @Id
    private Long id;
    private String title;
    private Long author;

    public Book() {
    }

    public Book(Long id, String title, Long author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }
}
