package ru.otus.library2.dao;

import org.springframework.stereotype.Repository;
import ru.otus.library2.domain.Book;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

  @PersistenceContext
  private final EntityManager em;

  public BookDaoImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void insertBook(Book book) {
    if (book.getId() <= 0) {
      em.persist(book);

    } else {
      em.merge(book);
    }
  }

  @Override
  public Optional<Book> readeBookById(long id) {
    return Optional.ofNullable(em.find(Book.class, id));
  }

  @Override
  public List<Book> readeAllBooks() {
    EntityGraph<?> entityGraph = em.getEntityGraph("book-author-genre-entity-graph");
    TypedQuery<Book> query = em.createQuery("select s from Book s", Book.class);
    query.setHint("javax.persistence.fetchgraph", entityGraph);
    return query.getResultList();
  }

  @Override
  public void deleteBookById(long id) {
    Query query = em.createQuery("delete " +
        "from Book  b " +
        "where b.id = :id");
    query.setParameter("id", id);
    query.executeUpdate();
  }
}
