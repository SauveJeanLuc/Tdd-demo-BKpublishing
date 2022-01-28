package com.example.books.services;

import com.example.books.dto.BookDto;
import com.example.books.models.Author;
import com.example.books.models.Book;
import com.example.books.repository.IBookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @Mock
    IBookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @Test
    public void returnBooks() {

        Author firstAuthor = new Author(30l, "Julia Show", LocalDate.of(1990,01,13));
        Author secondAuthor = new Author(31l, "Chinua Achebe", LocalDate.of(1982,02,15));
        when(bookRepository.findAll()).thenReturn(Arrays.asList(
                new Book(1l, "Breaking the silence", firstAuthor),
                new Book(2l, "The giver", firstAuthor),
                new Book(3l, "My name is life", secondAuthor)));
        assertEquals(2, bookService.getAll().get(1).getId());
    }

    @Test
    public void createBook() {
        Author firstAuthor = new Author(30l, "John", LocalDate.of(1990,01,13));
        when(bookRepository.save(ArgumentMatchers.any(Book.class))).thenReturn(new Book(3l, "Breaking The Silence", firstAuthor));
        assertEquals("Breaking The Silence",bookService.save( new BookDto()).getTitle());
    }


    @Test
    public void getBook_ByID() {
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(new Book(120l, "Go Girl", new Author())));

        assertEquals("Go Girl", bookService.getById(120).get().getTitle());
    }

    @Test
    public void getBook_ByID_404() {
        when(bookRepository.findById(anyLong())).thenReturn(null);
        assertEquals(null, bookService.getById(109));
    }

    @Test
    public void existsByName_test() {
        when(bookRepository.existsByTitle(anyString())).thenReturn(true);
        assertEquals(true, bookService.existsByTitle("Things Fall Apart"));
    }

    @Test
    public void existsByName_NotFound() {
        when(bookRepository.existsByTitle(anyString())).thenReturn(false);
        assertEquals(false, bookService.existsByTitle("Miracle Worker"));
    }


}
