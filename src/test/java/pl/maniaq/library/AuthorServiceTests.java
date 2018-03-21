package pl.maniaq.library;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.maniaq.library.dao.AuthorDao;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.service.AuthorService;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthorServiceTests {

    @Autowired
    AuthorService authorService;
    @Autowired
    AuthorDao authorDao;

    @Test
    public void testAddNewAuthor(){
        Author author = new Author("Alfred", "Dickens", new Date());

        authorService.addNewAuthor(author);

        Author authorFromRepo = authorDao.getAuthorByAuthorNameAndAuthorLastName("Alfred", "Dickens");

        Assert.assertEquals(author.getAuthorName(), authorFromRepo.getAuthorName());
        Assert.assertEquals(author.getAuthorLastName(), authorFromRepo.getAuthorLastName());
    }

    @Test
    public void testDeleteAuthor(){
        Author author = new Author("John", "Exs", new Date());

        authorDao.save(author);

        Long authorIdFromRepo = authorDao.getAuthorByAuthorNameAndAuthorLastName("John", "Exs").getId();

        authorService.removeAuthor(authorIdFromRepo);

        Assert.assertFalse(authorDao.existsById(authorIdFromRepo));

    }


}
