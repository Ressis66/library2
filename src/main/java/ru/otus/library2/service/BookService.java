package ru.otus.library2.service;

import ru.otus.library2.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
  void insertBook (Book book);
  Optional<Book> readeBookById(long id);
  List<Book> readeAllBooks();
  void deleteBookById(long id);
}
