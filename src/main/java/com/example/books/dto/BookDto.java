package com.example.books.dto;

import lombok.Data;

@Data
public class BookDto {

    private String title;

    private Long authorId;

    public BookDto(String title, Long authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public BookDto() {
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
