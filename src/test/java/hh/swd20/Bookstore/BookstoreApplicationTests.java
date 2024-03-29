package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Bookstore.webcontrol.BookController;
import hh.swd20.Bookstore.webcontrol.UserDetailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {
	
	@Autowired
	private BookController Bcontroller;
	
	@Autowired
	private UserDetailServiceImpl Ucontroller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(Bcontroller).isNotNull();
		assertThat(Ucontroller).isNotNull();
	}
	

}
