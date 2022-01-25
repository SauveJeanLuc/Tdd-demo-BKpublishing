package services;

import com.example.books.dto.AuthorDto;
import com.example.books.dto.BookDto;
import com.example.books.repository.IAuthorRepository;
import com.example.books.repository.IBookRepository;
import models.Author;
import models.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    public Optional<Author> getById(long id) {

        Optional<Author> book =  authorRepository.findById(id);

        return book;
    }

    public List<Author> getAll() {

        return authorRepository.findAll();
    }

    public boolean existsByTitle(String title) {

        return authorRepository.existsByFullNames(title);
    }


    public Author save(AuthorDto dto) {
        Author author =  new Author();
        author.setFullNames(dto.getFullNames());
        return authorRepository.save(author);
    }
}
