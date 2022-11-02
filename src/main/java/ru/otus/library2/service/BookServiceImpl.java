package ru.otus.library2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library2.domain.Book;
import ru.otus.library2.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Component
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Override
  public  void insertBook(Book book) {
    bookRepository.save(book);
  }

  @Override
  public Book readeBookById(Long id) {
    return bookRepository.findByBookId(id);
  }

  @Override
  public List<Book> readeAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public void deleteBookById(long id) {
    bookRepository.deleteById(id);
  }
}
