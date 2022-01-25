package com.example.books.services;

import com.example.books.dto.BookDto;
import com.example.books.repository.IBookRepository;
import com.example.books.utils.CustomException;
import models.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import services.BookService;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class bookService {
    @Mock
    IBookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @Test
    public void returnCities() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(
                new Book(1l, "Breaking the silence", 89l),
                new Book(2l, "The giver", 23l),
                new Book(3l, "My name is life", 2l)));
        assertEquals(2, bookService.getAll().get(1).getId());
    }

    @Test
    public void createBook() {
        when(bookRepository.save(ArgumentMatchers.any(Book.class))).thenReturn(new Book(3l, "Huye City", 23l));
        assertEquals("Huye City",bookService.save( new BookDto()).getTitle());
    }

//    @Test
//    public void createBookDuplicate(){
//
//        when(bookRepository.existsByTitle(anyString())).thenReturn(true);
//
//        Exception exception = assertThrows(CustomException.class, () -> bookService.save(new BookDto()));
//
//        assertEquals("Book name already registered", exception.getMessage());
//    }


    @Test
    public void getBook_ByID(){
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(new Book(120l, "Huye City", 2l)));

        assertEquals("Huye City", bookService.getById(120).get().getTitle());
    }

    @Test
    public void getBook_ByID_404() {
        when(bookRepository.findById(anyLong())).thenReturn(null);
        assertEquals(null, bookService.getById(109));
    }

    @Test
    public void existsByName_test() {
        when(bookRepository.existsByTitle(anyString())).thenReturn(true);
        assertEquals(true, bookService.existsByTitle("Musanze"));
    }

    @Test
    public void existsByName_NotFound() {
        when(bookRepository.existsByTitle(anyString())).thenReturn(false);
        assertEquals(false, bookService.existsByTitle("kgli"));
    }










}
