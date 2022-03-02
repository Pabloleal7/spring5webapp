package com.example.section2.bootstrap;

import com.example.section2.domain.Author;
import com.example.section2.domain.Book;
import com.example.section2.domain.Publisher;
import com.example.section2.repositories.AuthorRepository;
import com.example.section2.repositories.BookRepository;
import com.example.section2.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Ita Publishing");
        publisher.setCity("Itaberaba");
        publisher.setState("bahia");

        publisherRepository.save(publisher);

        Author pablo = new Author("Pablo","Leal");
        Book  livro1 = new Book("Livro1", "1232222");
        pablo.getBooks().add(livro1);
        livro1.getAuthors().add(pablo);
        livro1.setPublisher(publisher);
        publisher.getBooks().add(livro1);

        authorRepository.save(pablo);
        bookRepository.save(livro1);

        Author monica = new Author("Monica", "Silva");
        Book livro2 = new Book("Livromoni","123222");
        monica.getBooks().add(livro2);
        livro2.getAuthors().add(monica);

        livro2.setPublisher(publisher);
        publisher.getBooks().add(livro2);

        authorRepository.save(monica);
        bookRepository.save(livro2);
        publisherRepository.save(publisher);

        Publisher pub1 = new Publisher("lalala","Rua Mel","Itaberaba","Bahia","468");
        publisherRepository.save(pub1);
        Publisher pub2 = new Publisher("monica","Rua Melo","Itaberaba","Bahia","468");
        publisherRepository.save(pub1);
        publisherRepository.save(pub2);


        System.out.println(publisherRepository.count());
        publisherRepository.findAll().forEach(pub -> {
            System.out.println(pub.toString());
        });




        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books:"+ bookRepository.count());

    }
}
