package models;

import java.time.LocalDateTime;

public class Book {

    private Long id;
    private String title;
    private LocalDateTime publishedAt;
    private Author author;

    public Book() {
    }

    public Book(Long id, String title, LocalDateTime publishedAt, Author author) {
        this.id = id;
        this.title = title;
        this.publishedAt = publishedAt;
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

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
