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
import ru.otus.library2.domain.Genre;
import ru.otus.library2.repository.GenreRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class GenreRestController {

  private GenreRepository repository;

  @Autowired
  public GenreRestController(GenreRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/genres")
  public ResponseEntity<Flux<Genre>> listGenre(Model model) {
    Flux<Genre> genres = repository.findAll();
    return new ResponseEntity<>(genres, HttpStatus.OK);
  }

  @GetMapping(value = "/genres/{id}")
  public ResponseEntity<Mono<Genre>> getGenreById(@PathVariable(name = "id") String id) {
    Mono<Genre> genre = repository.findGenreById(id);

    if (genre == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(genre, HttpStatus.OK);
  }

  @PostMapping(value = "/genres", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Mono<Genre>> addGenre(@RequestBody Genre genre) {

    Mono<Genre> genre1 = repository.save(genre);
    return new ResponseEntity<>(genre1, HttpStatus.CREATED);
  }

  @PutMapping("/genres/{id}")
  public Mono<ResponseEntity<Genre>> updateGenre(@PathVariable(value = "id") String genreId,
                                                   @Valid @RequestBody Genre genre) {
    return repository.findById(genreId)
        .flatMap(existingGenre -> {
          existingGenre.setName(genre.getName());
          return repository.save(existingGenre);
        })
        .map(updatedGenre -> new ResponseEntity<>(updatedGenre, HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/genres/{id}")
  public ResponseEntity<Mono<Genre>> deleteGenre(@PathVariable String id) {
    repository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
