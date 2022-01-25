package com.example.books.dto;

import java.time.LocalDateTime;

public class AuthorDto {


    private String fullNames;
    private LocalDateTime dob;
    private Long id;

    public AuthorDto() {
    }

    public AuthorDto(Long id, String fullNames, LocalDateTime dob) {
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
