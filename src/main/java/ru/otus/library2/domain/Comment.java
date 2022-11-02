package ru.otus.library2.domain;


import org.springframework.data.annotation.Id;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

@Table(name = "commits")
@NamedEntityGraph(name = "book-commit-entity-graph",
    attributeNodes = {@NamedAttributeNode("book")})
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "content", nullable = false, unique = true)
  private String content;

  @ManyToOne(targetEntity = Genre.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "book_id")
  private Book book;

  public Comment(String content, Book book) {
    this.content = content;
    this.book = book;
  }
  public Comment(Long id, String content, Book book) {
    this.id = id;
    this.content = content;
    this.book = book;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }
}
