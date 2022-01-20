package pl.pjatk.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.library.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByTitle(String title);
}
