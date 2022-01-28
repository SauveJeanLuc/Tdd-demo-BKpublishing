package com.example.books.controllers;

import com.example.books.dto.AuthorDto;
import com.example.books.models.Author;
import com.example.books.services.AuthorService;
import com.example.books.utils.APICustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") long id) {

        Optional<Author> author = authorService.getById(id);

        if (author.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(author.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new APICustomResponse(false, "Author not found with id " + id));
    }

    @GetMapping("/all")
    public List<Author> getAll() {

        return authorService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveItem(@RequestBody AuthorDto dto) {

        if (authorService.existsByFullNames(dto.getFullNames())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new APICustomResponse(false, "Author with names " + dto.getFullNames() + " is registered already"));
        }
        Author author = authorService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(author);
    }
}
