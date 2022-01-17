package pl.pjatk.library.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.library.repositories.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorRestController {
    private final AuthorRepository authorRepository;

    public AuthorRestController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

}
