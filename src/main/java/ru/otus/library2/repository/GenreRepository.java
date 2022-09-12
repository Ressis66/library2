package ru.otus.library2.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library2.domain.Genre;


public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {

  @Override
  Mono<Genre> insert(Genre genre);

  Mono<Genre> findGenreById(String id);

  @Override
  Flux<Genre> findAll();

  @Override
  Mono<Void> deleteById(String id);

}
