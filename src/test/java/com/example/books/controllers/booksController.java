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
    public void getAllCities_Success() throws Exception {
        List<Book> asList = Arrays.asList(new Book(1,"Things Fall Apart", LocalDateTime.now()),
                new Book(2,"The Giver",LocalDateTime.now()));

        when(bookServiceMock.getAll()).thenReturn(asList);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/books/all")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1, \"name\":\"Kigali City\",\"weather\":23,\"fahrenheit\":23.90} ,{\"id\":2, \"name\":\"Kigali City\",\"weather\":23,\"fahrenheit\":23.90} ]"))
                .andReturn();

    }
}
