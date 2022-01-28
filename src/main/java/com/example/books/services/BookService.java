package com.example.books.services;

import com.example.books.dto.BookDto;
import com.example.books.models.Book;
import com.example.books.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public Optional<Book> getById(long id) {

        Optional<Book> book = bookRepository.findById(id);

        return book;
    }

    public List<Book> getAll() {

        return bookRepository.findAll();
    }

    public boolean existsByTitle(String title) {

        return bookRepository.existsByTitle(title);
    }


    public Book save(BookDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        return bookRepository.save(book);
    }

}