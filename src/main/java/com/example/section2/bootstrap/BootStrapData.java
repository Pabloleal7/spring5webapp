package com.example.section2.bootstrap;

import com.example.section2.domain.Author;
import com.example.section2.domain.Book;
import com.example.section2.repositories.AuthorRepository;
import com.example.section2.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author pablo = new Author("Pablo","Leal");
        Book  livro1 = new Book("Livro1", "1232222");
        pablo.getBooks().add(livro1);
        livro1.getAuthors().add(pablo);

        authorRepository.save(pablo);
        bookRepository.save(livro1);

        Author monica = new Author("Monica", "Silva");
        Book livro2 = new Book("Livromoni","123222");
        monica.getBooks().add(livro2);
        livro2.getAuthors().add(monica);

        authorRepository.save(monica);
        bookRepository.save(livro2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books:"+ bookRepository.count());

    }
}
