package ru.otus.library2.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.library2.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long> {

  Comment saveCommentById(Comment comment, Long bookId);

  @Override
  Optional<Comment> findById(Long id);


  List<Comment> findAllByBook(Long id);

  @Override
  void deleteById(Long id);
}
