package com.example.books.services;


import com.example.books.repository.IAuthorRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceTest {
    @Mock
    IAuthorRepository authorRepository;

    @InjectMocks
    AuthorService authorService;
}
