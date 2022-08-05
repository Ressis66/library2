package ru.otus.library2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.library2.domain.Book;
import ru.otus.library2.repository.BookRepository;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

  @Autowired
  private BookRepository repository;

  @GetMapping("/")
  public String listBook(Model model) {
    List<Book> books = repository.findAll();
    model.addAttribute("books", books);
    return "bookList";
  }

  @GetMapping("/signup")
  public String showSignUpForm(Book book) {
    return "add-book";
  }

  @PostMapping("/addBook")
  public String addUser(@Valid Book book, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "add-book";
    }

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
                           BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return "edit";
    }

    repository.save(book);
    return "redirect:/";
  }

  @GetMapping("/deleteBook")
  public String deleteBook(@RequestParam("BookId") Long id) {
    repository.deleteById(id);
    return "redirect:/";
  }
}


