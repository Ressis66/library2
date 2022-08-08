package ru.otus.library2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.library2.domain.Author;
import ru.otus.library2.domain.Book;
import ru.otus.library2.domain.Genre;
import ru.otus.library2.repository.AuthorRepository;
import ru.otus.library2.repository.BookRepository;
import org.springframework.ui.Model;
import ru.otus.library2.repository.GenreRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

  @Autowired
  private BookRepository repository;

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  private GenreRepository genreRepository;


  @GetMapping("/")
  public String listBook(Model model) {
    List<Book> books = repository.findAll();
    model.addAttribute("books", books);
    return "bookList";
  }

  @ModelAttribute("authors")
  public List<Author> getAuthors()  {
    List<Author> authors = authorRepository.findAll();
    return authors;
  }

  @ModelAttribute("genres")
  public List<Genre> getGenres () {
    List<Genre> genres = genreRepository.findAll();
    return genres;
  }

  @PostMapping("/addBook")
  public String addBook(@ModelAttribute("book") Book book, @ModelAttribute("author.id") Long authorId, @ModelAttribute("genre.id") Long genreId, Model model) {
    book.setAuthor(authorRepository.findAuthorById(authorId));
    book.setGenre(genreRepository.findGenreById(genreId));
    repository.save(book);
    return "redirect:/";
  }

  @GetMapping("/edit")
  public String editBook(@RequestParam("id") Long id, Model model) {
    Book book = repository.findBookById(id);
    model.addAttribute("book", book);
    return "edit";
  }

  @Validated
  @PostMapping("/edit")
  public String updateBook(@Valid @ModelAttribute("book") Book book,
                           @ModelAttribute("author.id") Long authorId, @ModelAttribute("genre.id") Long genreId,
                           BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return "edit";
    }
    book.setAuthor(authorRepository.findAuthorById(authorId));
    book.setGenre(genreRepository.findGenreById(genreId));
    repository.save(book);
    return "redirect:/";
  }



  @GetMapping("/signup")
  public String showSignUpForm(Book book) {
    return "addBook";
  }



  @GetMapping("/deleteBook")
  public String deleteBook(@RequestParam("BookId") Long id) {
    repository.deleteById(id);
    return "redirect:/";
  }
}


