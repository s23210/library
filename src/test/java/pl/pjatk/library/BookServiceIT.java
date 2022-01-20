package pl.pjatk.library;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.pjatk.library.domain.Author;
import pl.pjatk.library.domain.Book;
import pl.pjatk.library.repositories.AuthorRepository;
import pl.pjatk.library.repositories.BookRepository;
import pl.pjatk.library.services.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class BookServiceIT {
    @Autowired
    private BookService bookService;
    @MockBean
    private BookRepository bookRepository;
    @MockBean
    private AuthorRepository authorRepository;

    @Test
    void shouldAddPrefixToTitle() {
        //GIVEN
        Book book = new Book("exampleTitle", null, null, null);
        //WHEN
        bookService.addPrefixToTitle(book, "PREFIX_");
        //THEN
        assertThat(book.getTitle()).isEqualTo("PREFIX_exampleTitle");
    }

    @Test
    void shouldNotAddPrefixToTitle() {
        //GIVEN
        Book book = new Book(null, null, null, null);
        //WHEN
        bookService.addPrefixToTitle(book, "PREFIX_");
        //THEN
        assertThat(book.getTitle()).isNull();
    }

    @Test
    void shouldChangeBookTitle() {
        //GIVEN
        Book book = new Book("exampleTitle", null, null, null);
        //WHEN
        bookService.changeBookTitle(book, "newTitle");
        //THEN
        assertThat(book.getTitle()).isEqualTo("newTitle");
    }

    @Test
    void shouldNotChangeBookTitle() {
        //GIVEN
        Book book = new Book(null, null, null, null);
        //WHEN
        bookService.changeBookTitle(book, "newTitle");
        //THEN
        assertThat(book.getTitle()).isNull();
    }

    @Test
    void shouldAddAuthorToBook() {
        //GIVEN
        Book book = new Book(null, null, null, new ArrayList<>());
        Author author = new Author(null, null, null);
        //WHEN
        bookService.addAuthorToBook(book, author);
        //THEN
        assertThat(book.getAuthors()).isNotNull().hasSize(1);
    }

    @Test
    void shouldNotAddAuthorToBook() {
        //GIVEN
        Book book = new Book(null, null, null, null);
        Author author = new Author(null, null, null);
        //WHEN
        bookService.addAuthorToBook(book, author);
        //THEN
        assertThat(book.getAuthors()).isNull();
    }

    @Test
    void shouldCountAuthorsById() {
        Mockito.when(authorRepository.countByBooksId(any()))
                .thenReturn(3);

        int countAuthors = bookService.countAuthorsByBookId(1);
        assertThat(countAuthors).isNotNull().isEqualTo(3);
    }

    @Test
    void shouldDeleteById() {
        //WHEN
        bookService.deleteById(1);
        //THEN
        Mockito.verify(bookRepository).deleteById(any());
    }

    @Test
    void shouldFindById() {
        Mockito.when(bookRepository.findById(any()))
                .thenReturn(Optional.of(new Book()));

        Book byId = bookService.findById(1);

        assertThat(byId).isNotNull();
    }

    @Test
    void shouldFNotFindById() {
        Mockito.when(bookRepository.findById(any()))
                .thenReturn(Optional.empty());

        Book byId = bookService.findById(1);

        assertThat(byId).isNull();
    }

    @Test
    void shouldGetAllBooks() {
        //GIVEN
        List<Book> books = List.of(new Book(), new Book());
        //WHEN
        Mockito.when(bookRepository.findAll())
                .thenReturn(books);

        List<Book> all = bookService.getAllBooks();
        //THEN
        assertThat(all).hasSize(books.size());
    }

    @Test
    void shouldGetEmptyBookList() {
        //GIVEN
        List<Book> books = List.of();
        //WHEN
        Mockito.when(bookRepository.findAll())
                .thenReturn(books);

        List<Book> all = bookService.getAllBooks();
        //THEN
        assertThat(all).isEmpty();
    }
}
