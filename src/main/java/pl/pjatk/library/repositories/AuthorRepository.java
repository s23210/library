package pl.pjatk.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.library.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
