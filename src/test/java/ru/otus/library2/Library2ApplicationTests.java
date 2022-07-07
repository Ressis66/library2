package ru.otus.library2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.library2.dao.AuthorDaoImpl;
import ru.otus.library2.dao.BookDaoImpl;
import ru.otus.library2.dao.GenreDaoImpl;

@DataJpaTest
@RunWith(SpringRunner.class)
@Import({AuthorDaoImpl.class, BookDaoImpl.class, GenreDaoImpl.class})
class Library2ApplicationTests {
	@Autowired
	private AuthorDaoImpl authorDao;

	@Autowired
	private GenreDaoImpl genreDao;

	@Autowired
	private BookDaoImpl bookDao;

	@Test
	void contextLoads() {

		Assertions.assertNotNull(bookDao.readeAllBooks());
		Assertions.assertNotNull(genreDao.readeAllGenres());
		Assertions.assertNotNull(authorDao.readeAllAuthors());
	}

}
