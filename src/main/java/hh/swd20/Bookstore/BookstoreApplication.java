package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository drepository) {
		return (args) -> {
			log.info("save a few books");
			drepository.save(new Category("Business"));
			drepository.save(new Category("Romance"));
			drepository.save(new Category("Fantasy"));
			
			repository.save(new Book("Rich Dad Poor Dad", "Robert T. Kiyosaki",2011, "1612680011", 20, drepository.findByName("Business").get(0)));
			repository.save(new Book("The alchemist", "Paulo Coelho", 2006, "9780061122415", 15, drepository.findByName("Fantasy").get(0)));		

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
}
