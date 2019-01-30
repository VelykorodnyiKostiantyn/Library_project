package data_handling.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import data_handling.model.*;
import data_handling.service.*;

public class DataHandling {
	public static void main (String[] args) {
	    ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
	    for (String s: context.getBeanDefinitionNames())   {
	    	System.out.println("found bean: " + s);
	    }
	    
	    Object bm = context.getBean("bookManagerImpl");
	    
	    
	    StudentManager sm = (StudentManager)context.getBean("studentManagerImpl");
	    Student student1 = new Student("Joshua", "Brill", "jb@g.com");
	    
		sm.addStudent(student1);
		Student student2 = new Student("James", "Bond", "bond007@mi6.gov.gb");
		sm.addStudent(student2);
		sm.addStudent(new Student("Peter", "Pan", "PPP@neverland.gov"));
		for(Student s: sm.searchStudent( new Student("","","") )){
			System.out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());
		}
		student1.setEmail("masterbrill@gmail.com");
		sm.updateStudent(student1);
		Student student3 = sm.getStudent(1);
		System.out.println("Details : "+student3.getIdent()+" "+student3.getFirstName()+" " + student3.getLastName()+" "+ student3.getEmail());
		sm.deleteStudent(student2);
		
//		int student1 =dh.addStudent("James", "Bond", "bond007@mi6.gov.gb");
//		int student2 =dh.addStudent("John", "Doe", "A047@agency.com");
//		Book book1 = new Book("aaa","ccc");
//		List<Student> students = dh.showStudents();
//		for(Student s: students){
//			System.out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());
//
//		}
//
//		dh.updateStudent(student1,"", "", "anonimous007@mi6.gov.gb");
//		dh.deleteStudent(student2);
//		
//		students = dh.showStudents();
//		for(Student s: students){
//			System.out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());
//
//		}
//		
//		students = dh.findStudents(1,"" ,"sil","");
//		for(Student s: students){
//			System.out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());
//
//		}
	} 
}
