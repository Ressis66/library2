package ru.otus.library2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.library2.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Long> {
  @Override
  Genre save(Genre genre);

  Genre findGenreById(Long id);

  @Override
  List<Genre> findAll();

  @Override
  void deleteById(Long id);
}
