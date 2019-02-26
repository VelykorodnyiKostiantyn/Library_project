package data_handling.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import data_handling.model.Book;
import data_handling.service.BookManager;
import data_handling.validator.BookValidator;

@Controller
public class BookController {
	@Autowired
	private BookManager bookManager;

	@Autowired
	private BookValidator bookValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(bookValidator);
	}

	@RequestMapping(value = "/books")
	public String bookView(@ModelAttribute("book") Book book, ModelMap model) {
		if (book == null) 
		{
			book= new Book(); 
			System.out.println("search condition created");
		}
		List<Book> books = bookManager.searchBook(book);
		model.addAttribute("books", books);
		return "books";
	}
	
	@RequestMapping(value = "/books/new", method = RequestMethod.GET)
	public String bookAddForm(ModelMap model) {
		model.addAttribute("action", "new");
		model.addAttribute("book", new Book());
		return "bookForm";
	}

	@RequestMapping(value = "/books/new", method = RequestMethod.POST)
	public String bookAdd(@Validated @ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "bookForm";
		}
		bookManager.addBook(book);
		model.addAttribute("title", book.getTitle());
		model.addAttribute("author", book.getAuthor());
		return "bookResult";
	}
	
	@RequestMapping(value = "/books/{bookId}/edit", method = RequestMethod.GET)
	public String bookEditForm(@PathVariable int bookId ,ModelMap model) {
		Book book = bookManager.getBook(bookId);
		model.addAttribute("action", "edit");
		model.addAttribute("book", book );
		return "bookForm";
	}
	
	@RequestMapping(value = "/books/{bookId}/edit", method = RequestMethod.POST)
	public String bookEdit(@Validated @ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "bookForm";
		}
		bookManager.updateBook(book);
		model.addAttribute("title", book.getTitle());
		model.addAttribute("author", book.getAuthor());
		return "bookResult";
	}	
	
	@RequestMapping(value = "/books/{bookId}/delete", method = RequestMethod.GET)
	public String bookDelete(@PathVariable int bookId ,ModelMap model) {
		
		Book book = bookManager.getBook(bookId);
		bookManager.deleteBook(book);		
		model.addAttribute("book", book);
		return "bookDelete";
	}

}
