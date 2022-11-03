package ru.otus.library2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.library2.repository.AuthorRepository;
import ru.otus.library2.repository.BookRepository;
import ru.otus.library2.repository.GenreRepository;

@DataJpaTest
@RunWith(SpringRunner.class)

class Library2ApplicationTests {
@Autowired
	private AuthorRepository authorDao;

	@Autowired
	private GenreRepository genreDao;

	@Autowired
	private BookRepository bookDao;

	@Test
	void contextLoads() {

		Assertions.assertNotNull(bookDao.findAll());
		Assertions.assertNotNull(genreDao.findAll());
	  Assertions.assertNotNull(authorDao.findAll());
	}

}
