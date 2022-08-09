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
  public Genre insertGenre(Genre genre) {
    return genreRepository.save(genre);
  }

  @Override
  public Genre readeGenreById(long id) {
    return genreRepository.findGenreById(id);
  }

  @Override
  public List<Genre> readeAllGenres() {
    return genreRepository.findAll();
  }

  @Override
  public void deleteGenreById(long id) {
     genreRepository.deleteById(id);
  }

  @Override
  public void updateGenre(Long id, Genre genre) {
    Genre genreFromDb = genreRepository.findById(id).get();
    System.out.println(genreFromDb.toString());
    genreFromDb.setName(genre.getName());
    genreRepository.save(genreFromDb);
  };

}
