package ru.otus.library2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

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

  public Genre(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Genre(Long id) {
    this.id = id;
  }

  public Genre(String name) {
    this.name = name;
  }
  public Genre() {
  }

  @Override
  public String toString() {
    return "Genre{" +
        "name='" + name + '\'' +
        '}';
  }
}
