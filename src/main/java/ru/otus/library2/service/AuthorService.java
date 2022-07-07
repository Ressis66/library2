package ru.otus.library2.service;

import ru.otus.library2.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
  void insertAuthor(String name);
  Optional<Author> readeAuthorById(long id);
  List<Author> readeAllAuthors();
  void deleteAuthorById(long id);
}
