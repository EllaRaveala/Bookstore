package hh.swd20.Bookstore.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository drepository; 
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getWelcomePage(Model malli) {
		malli.addAttribute("book", new Book()); 
		return "Welcome";
	}
	
	 @RequestMapping(value="/books", method = RequestMethod.GET)
	    public @ResponseBody List<Book> getBooksRest() {	
	        return (List<Book>) repository.findAll();
	    }    

		// RESTful service to get car by id
	    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> getBookRest(@PathVariable("id") Long bookId) {	
	    	return repository.findById(bookId);
	    }
	
	 @RequestMapping(value="/booklist", method = RequestMethod.GET)
	    public String studentList(Model model) {	
	        model.addAttribute("books", repository.findAll());
	        return "Booklist";
	    }
	 
	 @RequestMapping(value = "/add")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	    	model.addAttribute("categories", drepository.findAll());
	        return "AddBook";
	    }     
	    
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
	        return "redirect:booklist";
	    } 
	    
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	    repository.deleteById(bookId);
	    return "redirect:../booklist";
	    }
	    
	    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public String addBook(@PathVariable("id") Long bookId, Model model){
	    model.addAttribute("book", repository.findById(bookId));
	    model.addAttribute("categories", drepository.findAll());
	    return "EditBook";
	    }
}
