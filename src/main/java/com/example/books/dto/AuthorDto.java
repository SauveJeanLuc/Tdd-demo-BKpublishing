package com.example.books.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthorDto {

    private String fullNames;

    private LocalDateTime dob;

    private Long id;

}
