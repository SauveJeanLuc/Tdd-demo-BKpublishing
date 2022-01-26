package com.example.books.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Book {
    @Id
    private Long id;

    private String title;

    private Long author;

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

}
