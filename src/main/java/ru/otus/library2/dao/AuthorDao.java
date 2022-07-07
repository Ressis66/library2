package ru.otus.library2.dao;

import ru.otus.library2.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
  void insertAuthor(String name);
  Optional <Author> readeAuthorById(long id);
  List<Author> readeAllAuthors();
  void deleteAuthorById(long id);
}
