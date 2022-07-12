package ru.otus.library2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.otus.library2.domain.Author;
import ru.otus.library2.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorServiceImpl implements AuthorService{

  @Autowired
  private AuthorRepository authorRepository;

  @Override
  public void insertAuthor(Author author) {
     authorRepository.save(author);
  }

  @Override
  public Optional<Author> readeAuthorById(long id) {
    return authorRepository.findById(id);
  }

  @Override
  public List<Author> readeAllAuthors() {
    return authorRepository.findAll();
  }

  @Override
  public void deleteAuthorById(long id) {
    authorRepository.deleteById(id);
  }
}
