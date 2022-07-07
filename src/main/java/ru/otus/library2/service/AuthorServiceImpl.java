package ru.otus.library2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.library2.dao.AuthorDao;
import ru.otus.library2.domain.Author;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorServiceImpl implements AuthorService{

  @Autowired
  private AuthorDao authorDao;

  @Override
  public void insertAuthor(String name) {
     authorDao.insertAuthor(name);
  }

  @Override
  public Optional<Author> readeAuthorById(long id) {
    return authorDao.readeAuthorById(id);
  }

  @Override
  public List<Author> readeAllAuthors() {
    return authorDao.readeAllAuthors();
  }

  @Override
  public void deleteAuthorById(long id) {
    authorDao.deleteAuthorById(id);
  }
}
