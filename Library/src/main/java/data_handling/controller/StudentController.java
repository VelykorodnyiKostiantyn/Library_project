package data_handling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import data_handling.model.Student;
import data_handling.service.StudentManager;





@Controller
public class StudentController {
	@Autowired
	private StudentManager studentManager;
	
    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
  public ModelAndView addStudentForm() {
    	System.out.println("resolve addStudent");
      return new ModelAndView("addStudentForm", "student", new Student());
  }
	
    @RequestMapping(value = "/addStudentAction", method = RequestMethod.POST)   
  public String submit(@Validated @ModelAttribute("student")Student student, 
    BindingResult result, ModelMap model) {
    	System.out.println("resolve addStudentAction");
      if (result.hasErrors()) {
          return "inputError";
      }
      studentManager.addStudent(student);
      model.addAttribute("firstName", student.getFirstName());
      model.addAttribute("lastName", student.getLastName());
      model.addAttribute("ident", student.getIdent());
      model.addAttribute("email", student.getEmail());
      return "addStudentResult";
  }

}




//
//import com.commerzbank.ga2veln.springMvc.model.Employee;
//
//@Controller
//public class EmployeeController {
// 
//    @RequestMapping(value = "/employee", method = RequestMethod.GET)
//    public ModelAndView showForm() {
//    	System.out.print("form");
//        return new ModelAndView("form", "employee", new Employee());
//    }
//
//     @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)   
//    public String submit(@Validated @ModelAttribute("employee")Employee employee, 
//      BindingResult result, ModelMap model) {
//    	    System.out.print("Start_Mapping");
//        if (result.hasErrors()) {
//            return "error";
//        }
//        model.addAttribute("name", employee.getName());
//        model.addAttribute("contactNumber", employee.getContactNumber());
//        model.addAttribute("id", employee.getId());
//        System.out.print("FU");
//        return "employeeView";
//    }
//}
