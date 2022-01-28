package com.example.books.controllers;

import com.example.books.dto.BookDto;
import com.example.books.utils.CustomException;
import com.example.books.utils.JsonUtil;
import com.example.books.models.Book;
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
import com.example.books.services.BookService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BooksController.class)
public class BooksControllerTest {
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
                .get("/api/books/id/2")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2, \"title\":\"High School Girlz\"}"))
                .andReturn();
    }


    @Test
    public void getOneBook_404() throws Exception {
        Book book =new Book(2L,"High School Girlz");
        when(bookServiceMock.getById(book.getId())).thenReturn(java.util.Optional.of(book));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/books/id/202")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\"status\":false,\"message\":\"Book not found\"}"))
                .andReturn();
    }

    @Test
    public void createBookTest() throws Exception{
        Book book = new Book(2L,"High School Girlz");
        when(bookServiceMock.save(new BookDto())).thenReturn(book);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/api/books/add")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(book));

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void create_test_duplicateCity() throws Exception {
        when(bookServiceMock.save(any(BookDto.class))).thenThrow(new CustomException("Book Title already registered", HttpStatus.BAD_REQUEST));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":2, \"title\":\"High School Girlz\"}");

        mockMvc.perform(request).andExpect(status().isBadRequest()).andExpect(content().string("Book Title already registered")).andReturn();
    }
}
