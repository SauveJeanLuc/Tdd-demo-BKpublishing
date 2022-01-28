package com.example.books.dto;

import com.example.books.models.Author;

import java.time.LocalDateTime;

public class BookDto {
    private String title;
    private Long authorId;

    public BookDto() {
    }

    public BookDto( String title, LocalDateTime publishedAt, Long authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
