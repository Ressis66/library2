package ru.otus.library2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library2.domain.Author;
import ru.otus.library2.repository.AuthorRepository;

import javax.validation.Valid;

@RestController
public class AuthorRestController {

  private AuthorRepository repository;

  @Autowired
  public AuthorRestController(AuthorRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/authors")
  public ResponseEntity<Flux<Author>> listAuthor(Model model) {
    Flux<Author> authors = repository.findAll();
    return new ResponseEntity<>(authors, HttpStatus.OK);
  }

  @GetMapping(value = "/authors/{id}")
  public ResponseEntity<Mono<Author>> getBookById(@PathVariable(name = "id") String id) {
    Mono<Author> author = repository.findAuthorById(id);

    if (author == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(author, HttpStatus.OK);
  }

  @PostMapping(value = "/authors", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Mono<Author>> addAuthor(@RequestBody Author author) {

    Mono<Author> author1 = repository.save(author);
    return new ResponseEntity<>(author1, HttpStatus.CREATED);
  }

  @PutMapping("/authors/{id}")
  public Mono<ResponseEntity<Author>> updateAuthor(@PathVariable(value = "id") String authorId,
                                                 @Valid @RequestBody Author author) {
    return repository.findById(authorId)
        .flatMap(existingAuthor -> {
          existingAuthor.setName(author.getName());
          return repository.save(existingAuthor);
        })
        .map(updatedAuthor -> new ResponseEntity<>(updatedAuthor, HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/authors/{id}")
  public ResponseEntity<Mono<Author>> deleteAuthor(@PathVariable String id) {
    repository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
