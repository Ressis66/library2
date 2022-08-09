package ru.otus.library2.service;

import ru.otus.library2.domain.Book;

import java.util.List;

public interface BookService {
  Book insertBook (Book book);
  Book readeBookById(long id);
  List<Book> readeAllBooks();
  void updateBook(Long id, Book book);
  void deleteBookById(long id);
}
