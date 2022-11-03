package ru.otus.library2.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {

  @Id
  private String id;

  private String comment;

  @DBRef
  private Book book;

  public Comment() {
  }

  public Comment(String id, String comment) {
    this.id = id;
    this.comment = comment;

  }

  public Comment(String id, String comment, Book book) {
    this.id = id;
    this.comment = comment;
    this.book = book;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }
}
