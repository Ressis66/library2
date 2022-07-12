package ru.otus.library2.service;

import ru.otus.library2.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
  void insertGenre(Genre genre) ;
  Optional<Genre> readeGenreById(long id);
  List<Genre> readeAllGenres();
  void deleteGenreById(long id);
}
