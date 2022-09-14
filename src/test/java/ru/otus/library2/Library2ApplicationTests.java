package ru.otus.library2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import ru.otus.library2.domain.Author;
import ru.otus.library2.domain.Book;
import ru.otus.library2.domain.Genre;
import ru.otus.library2.repository.BookRepository;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
public class Library2ApplicationTests {

	@Autowired
	private BookRepository repository;

	@Test
	public void shouldSetIdOnSave() {
		Mono<Book> personMono = repository.save(new Book("12","Bill", new Author("Pit"), new Genre("Comedy")));

		StepVerifier
				.create(personMono)
				.assertNext(book -> assertNotNull(book.getId()))
				.expectComplete()
				.verify();
	}
}
