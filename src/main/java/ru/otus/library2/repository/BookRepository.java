package ru.otus.library2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.library2.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
  @Override
  Book save(Book book);

  Book findBookById(Long id);

  @Override
  List<Book> findAll();

  @Override
  void deleteById(Long id);
}

