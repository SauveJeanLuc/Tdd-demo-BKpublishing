package com.example.books.controllers;


import com.example.books.dto.BookDto;
import com.example.books.models.Book;
import com.example.books.services.BookService;
import com.example.books.utils.APICustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") long id) {

        Optional<Book> book = bookService.getById(id);

        if (book.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(book.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new APICustomResponse(false, "Book not found with id " + id));
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveItem(@RequestBody BookDto dto) {

        if (bookService.existsByTitle(dto.getTitle())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new APICustomResponse(false, "Book title " + dto.getTitle() + " is registered already"));
        }
        Book book = bookService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }


}
