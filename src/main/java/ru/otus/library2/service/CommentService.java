package ru.otus.library2.service;

import ru.otus.library2.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
  void insertCommit(Comment comment, Long id);
  Optional<Comment> readeCommentById(Long id);
  List<Comment> readeAllCommentsByBook(Long id);
  void deleteCommitById(long id);
}
