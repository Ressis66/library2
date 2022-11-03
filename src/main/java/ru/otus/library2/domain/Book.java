package ru.otus.library2.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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

 @ManyToOne(targetEntity = Author.class, cascade = CascadeType.ALL)
 @JoinColumn(name = "author_id")
 private Author author;

 @ManyToOne(targetEntity = Genre.class, cascade = CascadeType.ALL)
 @JoinColumn(name = "genre_id")
 private Genre genre;

 @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
 @JoinColumn(name = "commit_id")
 private  List<Comment> commentList;

 public Book(Long id, String name, Author author, Genre genre, List<Comment> commentList) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.genre = genre;
    this.commentList = commentList;
  }

  public Book(Long id, String name) {
    this.id = id;
    this.name = name;
  }
  public Book( String name) {
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

  public List<Comment> getCommitList() {
    return commentList;
  }

  public void setCommitList(List<Comment> commentList) {
    this.commentList = commentList;
  }
}
