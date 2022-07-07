package ru.otus.library2.dao;

import ru.otus.library2.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreDao {
  void insertGenre(String name) ;
  Optional<Genre> readeGenreById(long id);
  List<Genre> readeAllGenres();
  void deleteGenreById(long id);
}
