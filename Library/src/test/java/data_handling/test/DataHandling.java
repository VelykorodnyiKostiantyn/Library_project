package data_handling.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import data_handling.model.*;
import data_handling.service.*;
import data_handling.*;

public class DataHandling {
	public static void main (String[] args) {
	    ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
	    for (String s: context.getBeanDefinitionNames())   {
	    	System.out.println("found bean: " + s);
	    }
	    
	    //ApplicationContext context2 = ApplicationContextProvider.getApplicationContext()
	    
	   

	    //create DB tables
	    //have to check how auto DDL works in hibernate
	    DBInit db =ApplicationContextProvider.getApplicationContext().getBean(DBInit.class);
	    db.dropTables();
	    db.createTables();
	    
	    
	    //test student functions
	    System.out.println("Starting Student test");
	    StudentManager sm = context.getBean(StudentManager.class);
	    Student student1 = new Student("Joshua", "Brill", "jb@gmail.com");
	    
		sm.addStudent(student1);
		Student student2 = new Student("James", "Bond", "bond007@mi6.gov.gb");
		sm.addStudent(student2);
		sm.addStudent(new Student("Peter", "Pan", "PPP@neverland.gov"));
		for(Student s: sm.searchStudent( new Student("","","") )){
			System.out.println(s.toString());
		}
		student1.setEmail("masterbrill@gmail.com");
		sm.updateStudent(student1);
		for(Student s: sm.searchStudent( new Student("","","") )){
			System.out.println(s.toString());
		}
		sm.deleteStudent(student2);
		for(Student s: sm.searchStudent( new Student("","","") )){
			System.out.println(s.toString());
		}
		
		//test Book functions
		//can import of BookManager class be skipped some way? 
	    BookManager bm = context.getBean(BookManager.class);
		System.out.println("Starting Book test");
		Book book1 = new Book ("Atlas Shrugged", "Ayn Rand");
		bm.addBook(book1);
		Book book2 = new Book ("20 000 Leagues Under the Sea", "Jules Verne");
		bm.addBook(book2);
		book2.setBorrower(student1);
		bm.updateBook(book2);
		Book book3 = new Book ("4 hour workweek", "Tom Ferret");
		bm.addBook(book3);
		bm.addBook(new Book("The Anarchist Cookbook", "William Powell"));
		for(Book b: bm.searchBooks(new Book ("", "") )){
			System.out.println(b.toString());
		}
		book3.setAuthor("Tim Ferris");
		bm.updateBook(book3);
		bm.deleteBook(book1);
		for(Book b: bm.searchBooks(new Book ("", "") )){
			System.out.println(b.toString());
		}
		Book book4 = new Book ("", "");
		book4.setBorrower(student1);
		System.out.println(book4.toString());
		for(Book b: bm.searchBooks(book4)){
			System.out.println(b.toString());
		}
	} 
}
