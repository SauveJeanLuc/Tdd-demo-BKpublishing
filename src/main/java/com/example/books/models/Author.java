package com.example.books.models;

import java.time.LocalDateTime;

public class Author {
    private Long id;
    private String fullNames;
    private LocalDateTime dob;

    public Author() {
    }

    public Author(Long id, String fullNames, LocalDateTime dob) {
        this.id = id;
        this.fullNames = fullNames;
        this.dob = dob;
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

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }
}
