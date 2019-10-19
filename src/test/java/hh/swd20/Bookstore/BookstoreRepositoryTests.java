package hh.swd20.Bookstore;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTests {

	@Autowired
	private BookRepository Brepository;
	
	@Autowired
	private CategoryRepository Crepository;
	
	@Autowired
	private UserRepository Urepository;
	
	 Book book1;
	 Book book2;
	 List<Book> books;
	
	@Test
	public void findByTitleShouldReturnBook() {
	List<Book> books = Brepository.findByTitle("Rich Dad Poor Dad");
	assertThat(books).hasSize(1);
	assertThat(books.get(3).getAuthor()).isEqualTo("Robert T. Kiyosaki");
	}
	
	@Test
	public void createNewBookShouldBeSuccesful() {
	Book book = new Book("Love", "Mr.Romantic", 1970, "B18029", 8, new Category("Romance"));
	Brepository.save(book);
	assertThat(book.getId()).isNotNull();
	}
	
	@Test
    public void deleteBookByIdFromRepositoryShouldBeSuccessful() {
        Brepository.deleteById(book1.getId());
        assertThat(book1.getId()).isNull();
    }
	
	@Test
	public void findByNameShouldReturnCategory() {
	List<Category> categories = Crepository.findByName("Business");
	assertThat(categories).hasSize(2);
	assertThat(categories.get(0).getName()).isEqualTo("Business");
	}
	
	@Test
	public void createNewCategory() {
	Category category = new Category("Horror");
	Crepository.save(category);
	assertThat(category.getCategorytid()).isNotNull();
	}
	
	@Test
	public void findByNameShouldReturnUser() {
	User user = Urepository.findByUsername("user");
	assertThat(user.getRole()).isEqualTo("USER");
	}
	
	@Test
	public void createNewUser() {
	User user = new User("Guest", "gfjjgf", "USER", "guest@gmail.com");
	Urepository.save(user);
	assertThat(user.getId()).isNotNull();
	}
	
	
}
