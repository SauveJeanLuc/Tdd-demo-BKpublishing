package com.example.books.repository;

import com.example.books.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Long> {
    boolean existsByFullNames(String fullNames);
}
