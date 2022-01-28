package com.example.books.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthorDto {

    private String fullNames;

    private LocalDateTime dob;

    private Long id;

    public AuthorDto(String fullNames, LocalDateTime dob, Long id) {
        this.fullNames = fullNames;
        this.dob = dob;
        this.id = id;
    }

    public AuthorDto() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
