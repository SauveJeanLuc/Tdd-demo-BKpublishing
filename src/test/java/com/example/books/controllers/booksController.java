package com.example.books.controllers;

import controllers.BooksController;
import models.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import services.BookService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BooksController.class)
public class booksController {
    @MockBean
    private BookService bookServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllBooksSuccess() throws Exception {
        List<Book> asList = Arrays.asList(new Book(1L,"Things Fall Apart"),
                new Book(2L,"The Giver"));

        when(bookServiceMock.getAll()).thenReturn(asList);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/books/all")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1, \"title\":\"Things Fall apart\"} ,{\"id\":2, \"title\":\"The Giver\"} ]"))
                .andReturn();

    }

    @Test
    public void getOneBook_Success() throws Exception {
        Book book = new Book(2L,"High School Girlz");
        when(bookServiceMock.getById(2)).thenReturn(java.util.Optional.of(book));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/cities/id/2")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2, \"name\":\"Kigali City\",\"weather\":23,\"fahrenheit\":23.90}"))
                .andReturn();
    }
}
