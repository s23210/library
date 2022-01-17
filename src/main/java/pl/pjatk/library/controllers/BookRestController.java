package pl.pjatk.library.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return ResponseEntity.ok(bookService.getExampleBook());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
