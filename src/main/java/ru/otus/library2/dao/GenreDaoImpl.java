package ru.otus.library2.dao;

import org.springframework.stereotype.Repository;
import ru.otus.library2.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class GenreDaoImpl implements GenreDao{

  @PersistenceContext
  private final EntityManager em;

  public GenreDaoImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void insertGenre(String name) {
    Genre genre  = new Genre(name);
    if (genre.getId() <= 0) {
      em.persist(genre);
    } else {
      em.merge(genre);
    }
  }

  @Override
  public Optional<Genre> readeGenreById(long id) {
    return   Optional.ofNullable(em.find(Genre.class, id));
  }

  @Override
  public List<Genre> readeAllGenres() {
    TypedQuery<Genre> query = em.createQuery("select a from Genre a", Genre.class);
    return query.getResultList();
  }

  @Override
  public void deleteGenreById(long id) {
    Query query = em.createQuery("delete " +
        "from Genre g " +
        "where g.id = :id");
    query.setParameter("id", id);
    query.executeUpdate();
  }
}
