package ru.otus.library2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library2.domain.Author;
import ru.otus.library2.domain.Book;
import ru.otus.library2.domain.Comment;
import ru.otus.library2.domain.Genre;
import ru.otus.library2.service.AuthorService;
import ru.otus.library2.service.BookService;
import ru.otus.library2.service.CommentService;
import ru.otus.library2.service.GenreService;


import java.io.IOException;
import java.util.List;


@ShellComponent
public class ShellCommand {

  @Autowired
  AuthorService authorService;

  @Autowired
  BookService bookService;

  @Autowired
  GenreService genreService;

  @Autowired
  CommentService commentService;

  @ShellMethod(key = "create_author", value = "create username")
  public void createAuthor(
      @ShellOption({"username", "u"}) String username)  throws IOException {
    Author author = new Author(username);
    authorService.insertAuthor(author);

  }
  @ShellMethod(key = "reade_authors", value = "read authors")
  public void readAllAuthors(){
    authorService.readeAllAuthors().stream().forEach(s -> System.out.println(s));
  }

  @ShellMethod(key = "delete_authors", value = "delete authors")
  public void deleteAuthorAccordingToId(@ShellOption({"id", "i"}) long id){
    authorService.deleteAuthorById(id);
  }


  @ShellMethod(key = "create_book", value = "create bookname")
  public void createBook(
      @ShellOption({"bookname", "b"}) String name

  )  throws IOException {
 Book book = new Book(name);
    bookService.insertBook(book);

  }
  @ShellMethod(key = "reade_books", value = "read books")
  public void readAllBooks(){
    bookService.readeAllBooks().stream().forEach(s -> System.out.println(s));
  }

  @ShellMethod(key = "delete_books", value = "delete books")
  public void deleteBookAccordingToId(@ShellOption({"id", "i"}) long id){
    bookService.deleteBookById(id);
  }


  @ShellMethod(key = "create_genre", value = "create genrename")
  public void createGenre(
      @ShellOption({"genrename", "b"}) String genrename)  throws IOException {
    Genre genre = new Genre(genrename);
    genreService.insertGenre(genre);

  }

  @ShellMethod(key = "reade_genres", value = "read genres")
  public void readAllGenres(){
    genreService.readeAllGenres().stream().forEach(s -> System.out.println(s));
  }

  @ShellMethod(key = "delete_genre", value = "delete genres")
  public void deleteGenreAccordingToId(@ShellOption({"id", "i"}) long id){
    genreService.deleteGenreById(id);
  }

  @ShellMethod(key = "create_comment", value = "create comment")
  public void createComment(
      @ShellOption({"username", "u"}) String commit, @ShellOption({"bookId", "bId"}) Long id)  throws IOException {
    Book book = bookService.readeBookById(id);
    Comment comment1 = new Comment(commit, book);

  }
  @ShellMethod(key = "reade_comments", value = "reade comments")
  public void readeCommentsByBook(
      @ShellOption({"bookId", "bId"}) Long id)  throws IOException {
    List<Comment> comment = commentService.readeAllCommitsByBook(id);

  }

}

