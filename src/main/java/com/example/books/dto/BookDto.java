package com.example.books.dto;

import models.Author;

import java.time.LocalDateTime;

public class BookDto {
    private String title;
    private LocalDateTime publishedAt;
    private Long authorId;

    public BookDto() {
    }

    public BookDto( String title, LocalDateTime publishedAt, Long authorId) {
        this.title = title;
        this.publishedAt = publishedAt;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
