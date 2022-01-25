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
private IBookRepository bookRepo;

    public List<Book> getAll() {

        List<Book> items = bookRepo.findAll();

        return items;
    }


    public Optional<Book> getById(long id) {
        return bookRepo.findById(id);
    }

    public boolean existsByTitle(String title) {
        boolean bookExist=bookRepo.existsByTitle(title);

        return bookExist;
    }

    public Book save(BookDto dto) {
Book book1 = new Book();

        book1.setAuthor(dto.getAuthorId());
        book1.setTitle(dto.getTitle());
        bookRepo.save(book1);
//        book1.setId();
        return null;
    }
}
