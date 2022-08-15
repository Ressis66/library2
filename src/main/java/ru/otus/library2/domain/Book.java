package ru.otus.library2.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Book {
 @Id
 private String id;

 private String name;

 private Author author;

 private Genre genre;

  public Book(String  id, String name, Author author, Genre genre) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.genre = genre;
  }

  public Book(String  id, String name) {
    this.id = id;
    this.name = name;
  }
  public Book( String name) {
        this.name = name;
  }

  public Book() {
  }

  public String  getId() {
    return id;
  }

  public void setId(String  id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, author, genre);
  }
}
