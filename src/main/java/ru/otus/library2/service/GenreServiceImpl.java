package ru.otus.library2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.library2.dao.GenreDao;
import ru.otus.library2.domain.Genre;

import java.util.List;
import java.util.Optional;

@Component
public class GenreServiceImpl implements  GenreService{

  @Autowired
  private GenreDao genreDao;

  @Override
  public void insertGenre(String name) {
    genreDao.insertGenre(name);
  }

  @Override
  public Optional<Genre> readeGenreById(long id) {
    return genreDao.readeGenreById(id);
  }

  @Override
  public List<Genre> readeAllGenres() {
    return genreDao.readeAllGenres();
  }

  @Override
  public void deleteGenreById(long id) {
     genreDao.deleteGenreById(id);
  }
}
