package ru.otus.library2.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Author {
  @Id
  private String id;

  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Author(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Author(String name) {
    this.name = name;
  }

  public Author() {
  }

  @Override
  public String toString() {
    return name;
  }
}
