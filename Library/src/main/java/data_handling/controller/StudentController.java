package data_handling.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import data_handling.dto.BookDto;
import data_handling.dto.StudentBMForm;
import data_handling.dto.StudentDto;
import data_handling.service.BookManager;
import data_handling.service.StudentManager;
import data_handling.validator.StudentValidator;

@Controller
public class StudentController {
	@Autowired
	private StudentManager studentManager;
	@Autowired
	private BookManager bookManager;

	@Autowired
	private StudentValidator studentValidator;

	@InitBinder("student")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(studentValidator);
	}

	@RequestMapping(value = "/students")
	public String studentView(@ModelAttribute("student") StudentDto student, ModelMap model) {
		if (student == null) 
		{
			student= new StudentDto(); 
			System.out.println("search condition created");
		}
		List<StudentDto> students = studentManager.searchStudent(student);
		model.addAttribute("students", students);
		return "students";
	}
	
	@RequestMapping(value = "/students/new", method = RequestMethod.GET)
	public String studentAddForm(ModelMap model) {
		model.addAttribute("action", "new");
		model.addAttribute("student", new StudentDto());
		return "studentForm";
	}

	@RequestMapping(value = "/students/new", method = RequestMethod.POST)
	public String studentAdd(@Validated @ModelAttribute("student") StudentDto student, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "studentForm";
		}
		studentManager.addStudent(student);
		model.addAttribute("firstName", student.getFirstName());
		model.addAttribute("lastName", student.getLastName());
		model.addAttribute("ident", student.getIdent());
		model.addAttribute("email", student.getEmail());
		return "studentResult";
	}
	
	@RequestMapping(value = "/students/{studentId}/edit", method = RequestMethod.GET)
	public String studentEditForm(@PathVariable int studentId ,ModelMap model) {
		StudentDto student = studentManager.getStudent(studentId);
		model.addAttribute("action", "edit");
		model.addAttribute("student", student );
		return "studentForm";
	}
	
	@RequestMapping(value = "/students/{studentId}/edit", method = RequestMethod.POST)
	public String studentEdit(@Validated @ModelAttribute("student") StudentDto student, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "studentForm";
		}
		studentManager.updateStudent(student);
		model.addAttribute("firstName", student.getFirstName());
		model.addAttribute("lastName", student.getLastName());
		model.addAttribute("ident", student.getIdent());
		model.addAttribute("email", student.getEmail());
		return "studentResult";
	}	
	
	@RequestMapping(value = "/students/{studentId}/delete", method = RequestMethod.GET)
	public String studentDelete(@PathVariable int studentId ,ModelMap model) {
		
		StudentDto student = studentManager.getStudent(studentId);
		studentManager.deleteStudent(student);		
		model.addAttribute("student", student);
		return "studentDelete";
	}
	
	@RequestMapping(value = "/students/{studentId}/manage_books", method = RequestMethod.GET)
	public String studentEditBooks(@PathVariable int studentId ,ModelMap model) {
		StudentBMForm form = new StudentBMForm();
		StudentDto student = studentManager.getStudent(studentId);				
		Set<BookDto> books = new HashSet<BookDto>();		
		for (BookDto b:bookManager.searchBook(new BookDto())) {
			if (b.getBorrowerId() ==0) {
				books.add(b);
			}
		}
		form.setAddBooks(books);
		form.setStudent(student);
		//form.setRemoveBooks(student.getBooks());
		model.addAttribute("form", form );
		return "studentBooks";
	}
	
	@RequestMapping(value = "/students/{studentId}/manage_books", method = RequestMethod.POST)
	//, @ModelAttribute("form") StudentBMForm form
	public String studentSaveBooks(ModelMap model, @ModelAttribute("form") StudentBMForm form) {
		StudentDto student = studentManager.getStudent(form.getStudent().getIdent());
		Set<BookDto> books= student.getBooks();
		for (int i: form.getRemoveBooksIdent()) {
			BookDto book = new BookDto();
			book.setIdent(i);
			books.remove(book);
		}
		for (int i: form.getAddBooksIdent()) {
			BookDto book = new BookDto();
			book.setIdent(i);
			books.add(book);
		}
		student.setBooks(books);
		for (BookDto b : books) {
			System.out.println(b.getIdent());
		}
		studentManager.updateStudent(student);
		return studentEditBooks(student.getIdent(), model);
	}

}
