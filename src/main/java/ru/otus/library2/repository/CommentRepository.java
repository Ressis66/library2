package ru.otus.library2.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library2.domain.Book;
import ru.otus.library2.domain.Comment;

public interface CommentRepository  extends ReactiveMongoRepository<Comment,String> {
  @Override
  Mono<Comment> insert(Comment comment);

  Flux<Comment> findAllCommentsByBookId(String id);

  @Override
  Flux<Comment> findAll();

  @Override
  Mono<Void> deleteById(String id);
}
