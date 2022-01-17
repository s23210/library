package pl.pjatk.library.services;

import org.springframework.stereotype.Service;
import pl.pjatk.library.domain.Author;
import pl.pjatk.library.domain.Book;
import pl.pjatk.library.domain.Publisher;
import pl.pjatk.library.repositories.AuthorRepository;
import pl.pjatk.library.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book getExampleBook() {

        Author author = new Author(null, "exampleFname", "exampleLname", new ArrayList<Book>());
        Book book = new Book(null, "exampleTitle", "exampleISBN", null, new ArrayList<Author>());
//        book.setAuthors(List.of(author)); //nie dziala
        author.setBooks(List.of(book)); //dziala
        Publisher publisher = new Publisher(null, "exampleName", "exampleAddress", "exampleCity", new ArrayList<Book>());
        publisher.setBooks(List.of(book)); //dziala
//        book.setPublisher(publisher); //nie dziala

//        authorRepository.save(author);


        bookRepository.save(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
