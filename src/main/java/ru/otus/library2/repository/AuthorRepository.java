package ru.otus.library2.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library2.domain.Author;


@Repository
public interface AuthorRepository  extends ReactiveMongoRepository<Author,String> {
    @Override
    Mono<Author> save(Author author);

    Mono<Author> findAuthorById(String id);

    @Override
    Flux<Author> findAll();

    @Override
    Mono<Void> deleteById(String id);

}
