package pl.pjatk.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.library.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
