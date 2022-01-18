package pl.pjatk.library.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.library.domain.Book;
import pl.pjatk.library.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/example")
    public ResponseEntity<Book> getExampleBook() {
        Book exampleBook = bookService.getExampleBook();
        return ResponseEntity.ok(exampleBook);
    }

    @GetMapping("/exampleWithTitle")
    public ResponseEntity<Book> getBookForTitle(@RequestParam String title) {
        return ResponseEntity.ok(bookService.getBookForTitle(title));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
    }

    @GetMapping("how_many_authors/{id}")
    public String countAuthorsByBookId(@PathVariable("id") Integer id) {
        return "Book with id=" + id + " has " + bookService.countAuthorsById(id) + " authors.";
    }

    @GetMapping("title/{title}")
    public ResponseEntity<List<Book>> getByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(bookService.findByTitle(title));
    }
}
