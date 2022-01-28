package com.example.books.services;

import com.example.books.dto.AuthorDto;
import com.example.books.models.Author;
import com.example.books.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    public Optional<Author> getById(long id) {

        Optional<Author> book = authorRepository.findById(id);

        return book;
    }

    public List<Author> getAll() {

        return authorRepository.findAll();
    }

    public boolean existsByFullNames(String title) {

        return authorRepository.existsByFullNames(title);
    }


    public Author save(AuthorDto dto) {
        Author author =  new Author();
        author.setFullNames(dto.getFullNames());
        return authorRepository.save(author);
    }
}
