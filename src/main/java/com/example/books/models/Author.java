package com.example.books.models;

import java.time.LocalDateTime;

public class Author {
    private Long id;
    private String fullNames;

    public Author() {
    }

    public Author(Long id, String fullNames) {
        this.id = id;
        this.fullNames = fullNames;
    }

    public Author(Long id, String fullNames) {
        this.id = id;
        this.fullNames = fullNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

}
