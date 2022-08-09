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
import ru.otus.library2.domain.Book;
import ru.otus.library2.service.BookService;

import java.util.List;

@RestController
public class RestBookController {


  @Autowired
  private BookService service;

  @GetMapping("/books")
  public ResponseEntity<List<Book>> listBook(Model model) {
    List<Book> books = service.readeAllBooks();
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  @GetMapping(value = "/books/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable(name = "id") Long id) {
    Book book = service.readeBookById(id);

    if (book == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  @PostMapping(value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Book> addBook(@RequestBody Book book) {
    Book book1 = service.insertBook(book);
    return new ResponseEntity<>(book1, HttpStatus.CREATED);
  }

  @PutMapping("/books/{id}")
  public ResponseEntity<Book> updateBook(@RequestBody Book newBook, @PathVariable Long id) {
    service.updateBook(id, newBook);
    return new ResponseEntity<>(service.readeBookById(id), HttpStatus.OK);

  }

  @DeleteMapping("/books/{id}")
  public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
    service.deleteBookById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}