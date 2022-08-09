package ru.otus.library2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library2.domain.Book;
import ru.otus.library2.repository.BookRepository;

import java.util.List;

@Transactional
@Component
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Override
  public Book insertBook(Book book) {
     return bookRepository.save(book);
  }

  @Override
  public Book readeBookById(long id) {
    return bookRepository.findBookById(id);
  }

  @Override
  public List<Book> readeAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public void deleteBookById(long id) {
    bookRepository.deleteById(id);
  }

  @Override
  public void updateBook(Long id, Book book) {
    Book bookFromDb = bookRepository.findById(id).get();
    System.out.println(bookFromDb.toString());
    bookFromDb.setName(book.getName());
    bookFromDb.setGenre(book.getGenre());
    bookFromDb.setAuthor(book.getAuthor());
    bookRepository.save(bookFromDb);
  };
}
