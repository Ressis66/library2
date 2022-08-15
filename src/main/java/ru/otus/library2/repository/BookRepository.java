package ru.otus.library2.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library2.domain.Book;

import java.util.List;

@Repository
public  interface BookRepository extends ReactiveMongoRepository<Book, String> {
  @Override
  Mono<Book> save(Book book);

  Mono<Book> findBookById(String id);

  @Override
  Flux<Book> findAll();

  @Override
  Mono<Void> deleteById(String id);

}

