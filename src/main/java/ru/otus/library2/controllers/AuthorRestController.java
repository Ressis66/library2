package ru.otus.library2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import ru.otus.library2.domain.Author;
import ru.otus.library2.service.AuthorService;

import java.util.List;

@RestController
public class AuthorRestController {


  @Autowired
  private AuthorService service;

  @GetMapping("/authors")
  public ResponseEntity<List<Author>> listAuthor(Model model) {
    List<Author> authors = service.readeAllAuthors();
    return new ResponseEntity<>(authors, HttpStatus.OK);
  }

  @GetMapping(value = "/authors/{id}")
  public ResponseEntity<Author> getBookById(@PathVariable(name = "id") Long id) {
    Author author = service.readeAuthorById(id);

    if (author == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(author, HttpStatus.OK);
  }

  @PostMapping(value = "/authors", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Author> addAuthor(@RequestBody Author author) {

    Author author1 = service.insertAuthor(author);
    return new ResponseEntity<>(author1, HttpStatus.CREATED);
  }

  @PutMapping("/authors")
  public ResponseEntity<Author> updateAuthor(@RequestBody Author newAuthor, @PathVariable Long id) {
    service.updateAuthor(id, newAuthor);
    return new ResponseEntity<>(service.readeAuthorById(id), HttpStatus.OK);

  }

  @DeleteMapping("/authors/{id}")
  public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {
    service.deleteAuthorById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
