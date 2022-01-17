package pl.pjatk.library.services;

import org.springframework.stereotype.Service;
import pl.pjatk.library.domain.Author;
import pl.pjatk.library.domain.Book;
import pl.pjatk.library.repositories.AuthorRepository;
import pl.pjatk.library.repositories.BookRepository;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

//    public Author getExampleAuthor() {
////        Book book = new Book();
////        book.setTitle("It");
////        book.setIsbn("123456");
////        Author author = new Author();
////        author.setFirstName("Stephen");
////        author.setLastName("King");
////        author.addBook(book);
////        book.addAuthor(author);
////        authorRepository.save(author);
////        return author;
//    }
}
