package ru.otus.library2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.library2.domain.Genre;
import ru.otus.library2.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Component
public class GenreServiceImpl implements  GenreService{

  @Autowired
  private GenreRepository genreRepository;

  @Override
  public void insertGenre(Genre genre) {
    genreRepository.save(genre);
  }

  @Override
  public Optional<Genre> readeGenreById(long id) {
    return genreRepository.findById(id);
  }

  @Override
  public List<Genre> readeAllGenres() {
    return genreRepository.findAll();
  }

  @Override
  public void deleteGenreById(long id) {
     genreRepository.deleteById(id);
  }
}
