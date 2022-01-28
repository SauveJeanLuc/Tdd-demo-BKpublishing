package com.example.books.repository;

import com.example.books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
    boolean existsByTitle(String title);
}
