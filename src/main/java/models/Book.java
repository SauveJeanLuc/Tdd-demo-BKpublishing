package models;

import java.time.LocalDateTime;

public class Book {

    private Long id;
    private String title;
    private Long author;

    public Book() {
    }

    public Book(Long id, String title,  Long author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }
}
