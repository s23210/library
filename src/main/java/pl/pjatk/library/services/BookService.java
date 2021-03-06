package pl.pjatk.library.services;

import org.springframework.stereotype.Service;
import pl.pjatk.library.domain.Author;
import pl.pjatk.library.domain.Book;
import pl.pjatk.library.domain.Publisher;
import pl.pjatk.library.repositories.AuthorRepository;
import pl.pjatk.library.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book getExampleBook() {
        Author author = new Author( "exampleFname", "exampleLname", new ArrayList<Book>());
        Book book = new Book( "exampleTitle", "exampleISBN", null, new ArrayList<Author>());
        book.setAuthors(List.of(author, author));
        author.setBooks(List.of(book));
        Publisher publisher = new Publisher( "exampleName", "exampleAddress", "exampleCity", new ArrayList<Book>());
        publisher.setBooks(List.of(book));
        book.setPublisher(publisher);
        bookRepository.save(book);
        return book;
    }

    public Book getBookForTitle(String title) {
        return new Book(title, "exampleISBN", null, null);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book findById(Integer id) {
        Optional<Book> byId = bookRepository.findById(id);
        return byId.orElse(null);
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    public int countAuthorsByBookId(Integer id) {
            return authorRepository.countByBooksId(id);
    }

    public void addAuthorToBook(Book book, Author author) {
        if (book.getAuthors() != null) {
            book.getAuthors().add(author);
        }
    }

    public void changeBookTitle(Book book, String title) {
        if (book.getTitle() != null) {
            book.setTitle(title);
        }
    }

    public void addPrefixToTitle(Book book, String prefix) {
        if (book.getTitle() != null) {
            book.setTitle(prefix + book.getTitle());
        }
    }
}
