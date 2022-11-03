package ru.otus.library2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import ru.otus.library2.domain.Author;
import ru.otus.library2.domain.Book;
import ru.otus.library2.domain.Comment;
import ru.otus.library2.domain.Genre;
import ru.otus.library2.repository.BookRepository;
import reactor.test.StepVerifier;
import ru.otus.library2.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
public class Library2ApplicationTests {


	@Test
	public void shouldSetIdOnSave() {


	}
}