package com.example.books.controllers;


import com.example.books.dto.AuthorDto;
import com.example.books.models.Author;
import com.example.books.services.AuthorService;
import com.example.books.utils.CustomException;
import com.example.books.utils.JsonUtil;
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

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTests {

    @MockBean
    private AuthorService authorServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllAuthorsSuccess() throws Exception {
        List<Author> asList = Arrays.asList(new Author(1L,"Irabe 🤣🔥"),
                new Author(2L,"Pauline"));

        when(authorServiceMock.getAll()).thenReturn(asList);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/authors/all")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1, \"fullNames\":\"Irabe 🤣🔥\"} ,{\"id\":2, \"fullNames\":\"Pauline\"} ]"))
                .andReturn();

    }

    @Test
    public void getOneAuthor_Success() throws Exception {
        Author author = new Author(2L,"Lorenzo Loraine");
        when(authorServiceMock.getById(2)).thenReturn(java.util.Optional.of(author));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/authors/id/2")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2, \"title\":\"Lorenzo Loraine\"}"))
                .andReturn();
    }


    @Test
    public void getOneAuthor_404() throws Exception {
        Author author =new Author(2L,"Jacques");
        when(authorServiceMock.getById(author.getId())).thenReturn(java.util.Optional.of(author));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/authors/id/202")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\"status\":false,\"message\":\"Author not found\"}"))
                .andReturn();
    }

    @Test
    public void createAuthorTest() throws Exception{
        Author book = new Author(2L,"Luka");
        when(authorServiceMock.save(new AuthorDto())).thenReturn(book);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/api/authors/add")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(book));

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void create_test_duplicateAuthor() throws Exception {
        when(authorServiceMock.save(any(AuthorDto.class))).thenThrow(new CustomException("FullNames already used", HttpStatus.BAD_REQUEST));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":2, \"fullNames\":\"Lorenzo Loraine\"}");

        mockMvc.perform(request).andExpect(status().isBadRequest()).andExpect(content().string("FullNames already used")).andReturn();
    }
}