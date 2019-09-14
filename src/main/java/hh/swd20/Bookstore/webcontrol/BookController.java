package hh.swd20.Bookstore.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getWelcomePage(Model malli) {
		malli.addAttribute("book", new Book()); 
		return "Welcome";
	}
	 @RequestMapping(value="/index")
	    public String studentList(Model model) {	
	        model.addAttribute("books", repository.findAll());
	        return "bookslist";
	    }
}
