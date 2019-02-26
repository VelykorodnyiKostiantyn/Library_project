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
import data_handling.model.Student;
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

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(studentValidator);
	}

	@RequestMapping(value = "/students")
	public String studentView(@ModelAttribute("student") Student student, ModelMap model) {
		if (student == null) 
		{
			student= new Student(); 
			System.out.println("search condition created");
		}
		List<Student> students = studentManager.searchStudent(student);
		model.addAttribute("students", students);
		return "students";
	}
	
	@RequestMapping(value = "/students/new", method = RequestMethod.GET)
	public String studentAddForm(ModelMap model) {
		model.addAttribute("action", "new");
		model.addAttribute("student", new Student());
		return "studentForm";
	}

	@RequestMapping(value = "/students/new", method = RequestMethod.POST)
	public String studentAdd(@Validated @ModelAttribute("student") Student student, BindingResult result, ModelMap model) {
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
		Student student = studentManager.getStudent(studentId);
		model.addAttribute("action", "edit");
		model.addAttribute("student", student );
		return "studentForm";
	}
	
	@RequestMapping(value = "/students/{studentId}/edit", method = RequestMethod.POST)
	public String studentEdit(@Validated @ModelAttribute("student") Student student, BindingResult result, ModelMap model) {
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
		
		Student student = studentManager.getStudent(studentId);
		studentManager.deleteStudent(student);		
		model.addAttribute("student", student);
		return "studentDelete";
	}
	@RequestMapping(value = "/students/{studentId}/manage_books", method = RequestMethod.GET)
	public String studentEditBooks(@PathVariable int studentId ,ModelMap model) {
		Student student = studentManager.getStudent(studentId);
		model.addAttribute("student", student );		
		List<Book> books = bookManager.searchBook(new Book());
		for (Book b : books) {
			if (b.getBorrower() != null) {
				books.remove(b);
			}
		}
		model.addAttribute("books", books );
		return "studentBooks";
	}
	
	//@RequestMapping(value = "/students/{studentId}/manage_books", method = RequestMethod.POST)

}
