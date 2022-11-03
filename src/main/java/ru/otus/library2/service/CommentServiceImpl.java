package ru.otus.library2.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.library2.domain.Comment;
import ru.otus.library2.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {

  @Autowired
  private CommentRepository commentRepository;


  @Override
  public void insertCommit(Comment comment, Long id) {
    commentRepository.saveCommentById(comment, id);
  }

  @Override
  public Optional<Comment> readeCommentById(Long id) {
    return commentRepository.findById(id);
  }

  @Override
  public List<Comment> readeAllCommentsByBook(Long id) {
    return commentRepository.findAllByBook(id);
  }

  @Override
  public void deleteCommitById(long id) {
    commentRepository.deleteById(id);
  }
}
