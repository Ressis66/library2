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
import ru.otus.library2.service.GenreService;

import java.util.List;

@RestController
public class GenreRestController {

  @Autowired
  private GenreService service;

  @GetMapping("/genres")
  public ResponseEntity<List<Genre>> listGenre(Model model) {
    List<Genre> genres = service.readeAllGenres();
    return new ResponseEntity<>(genres, HttpStatus.OK);
  }

  @GetMapping(value = "/genres/{id}")
  public ResponseEntity<Genre> getGenreById(@PathVariable(name = "id") Long id) {
    Genre genre = service.readeGenreById(id);

    if (genre == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(genre, HttpStatus.OK);
  }

  @PostMapping(value = "/genres", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Genre> addGenre(@RequestBody Genre genre) {

    Genre genre1 = service.insertGenre(genre);
    return new ResponseEntity<>(genre1, HttpStatus.CREATED);
  }

  @PutMapping("/genres/{id}")
  public ResponseEntity<Genre> updateGenre(@RequestBody Genre newBook, @PathVariable Long id) {
    service.updateGenre(id, newBook);
    return new ResponseEntity<>(service.readeGenreById(id), HttpStatus.OK);

  }

  @DeleteMapping("/genres/{id}")
  public ResponseEntity<Genre> deleteGenre(@PathVariable Long id) {
    service.deleteGenreById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
