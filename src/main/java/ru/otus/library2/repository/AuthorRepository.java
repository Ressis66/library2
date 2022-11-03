package ru.otus.library2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.library2.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
  @Override
  Author save(Author author);

  @Override
  Optional<Author> findById(Long id);

  @Override
  List<Author> findAll();

  @Override
  void deleteById(Long id);
}
