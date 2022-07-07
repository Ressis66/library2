package ru.otus.library2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library2.dao.BookDao;
import ru.otus.library2.domain.Book;

import java.util.List;
import java.util.Optional;

@Transactional
@Component
public class BookServiceImpl implements BookService {

  @Autowired
  private BookDao bookDao;

  @Override
  public  void insertBook(Book book) {
    bookDao.insertBook(book);
  }

  @Override
  public Optional<Book> readeBookById(long id) {
    return bookDao.readeBookById(id);
  }

  @Override
  public List<Book> readeAllBooks() {
    return bookDao.readeAllBooks();
  }

  @Override
  public void deleteBookById(long id) {
    bookDao.deleteBookById(id);
  }
}
