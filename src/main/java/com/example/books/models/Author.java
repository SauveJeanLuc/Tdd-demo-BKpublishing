package com.example.books.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    private Long id;

    private String fullNames;

    private LocalDateTime dob;

    public Author(Long id, String fullNames) {
        this.id = id;
        this.fullNames = fullNames;
    }

}
