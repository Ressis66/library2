package ru.otus.library2.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "books")
@NamedEntityGraph(name = "book-author-genre-entity-graph",
    attributeNodes = {@NamedAttributeNode("author"),@NamedAttributeNode("genre")})
public class Book {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "name", nullable = false, unique = true)
 private String name;

 @OneToOne(targetEntity = Author.class, cascade = CascadeType.ALL)
 @JoinColumn(name = "author_id")
 private Author author;

 @OneToOne(targetEntity = Genre.class, cascade = CascadeType.ALL)
 @JoinColumn(name = "genre_id")
 private Genre genre;

  public Book(Long id, String name, Author author, Genre genre) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.genre = genre;
  }

  public Book(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Book() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", author=" + author +
        ", genre=" + genre +
        '}';
  }
}
