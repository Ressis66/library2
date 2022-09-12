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
import ru.otus.library2.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library2.repository.BookRepository;

import javax.validation.Valid;

@RestController
public class RestBookController {

  private BookRepository repository;

  @Autowired
  public RestBookController(BookRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/books")
  public ResponseEntity<Flux<Book>> listBook(Model model) {
    Flux<Book> books = repository.findAll();
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  @GetMapping(value = "/books/{id}")
  public ResponseEntity<Mono<Book>> getBookById(@PathVariable(name = "id") String  id) {
    Mono<Book> book = repository.findBookById(id);

    if (book == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  @PostMapping(value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Mono<Book>> addBook(@RequestBody Book book) {
    Mono<Book> book1 = repository.insert(book);
    return new ResponseEntity<>(book1, HttpStatus.CREATED);
  }

  @PutMapping("/books/{id}")
  public Mono<ResponseEntity<Book>> updateGenre(@PathVariable(value = "id") String bookId,
                                                 @Valid @RequestBody Book book) {
    return repository.findById(bookId)
        .flatMap(existingBook -> {
          existingBook.setName(book.getName());
          existingBook.setAuthor(book.getAuthor());
          existingBook.setGenre(book.getGenre());
          return repository.save(existingBook);
        })
        .map(updatedBook -> new ResponseEntity<>(updatedBook, HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/books/{id}")
  public ResponseEntity<Book> deleteBook(@PathVariable String id) {
    repository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}