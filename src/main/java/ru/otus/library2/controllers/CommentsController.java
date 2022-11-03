package ru.otus.library2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.library2.domain.Author;
import ru.otus.library2.domain.Comment;
import ru.otus.library2.repository.CommentRepository;

@RestController
public class CommentsController {

  @Autowired
  private CommentRepository commentRepository;

  @GetMapping(value = "/comments/{id}")
  public ResponseEntity<Flux<Comment>> getCommentsByBookId(@PathVariable(name = "id") String id) {
    Flux<Comment> comments = commentRepository.findAllCommentsByBookId(id);

    if (comments == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(comments, HttpStatus.OK);
  }


}
