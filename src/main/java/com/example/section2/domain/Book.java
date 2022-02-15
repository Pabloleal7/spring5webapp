package com.example.section2.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book", @JoinColumns(name = "book_id"),
    inverseJoinColumns = @JoinColumns(name = "author_id") )
    private Set<Author> autors;

    public Book(String title, String isbn, Set<Author> autors) {
        this.title = title;
        this.isbn = isbn;
        this.autors = autors;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAutors() {
        return autors;
    }

    public void setAutors(Set<Author> autors) {
        this.autors = autors;
    }


}
