package data_handling.validator;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import data_handling.model.Student;

@Component
public class StudentValidator implements Validator {

   @Override
   public boolean supports(Class<?> c) {
      return Student.class.equals(c);
   }

   @Override
   public void validate(Object obj, Errors err) {

      ValidationUtils.rejectIfEmpty(err, "firstName", "student.firstName.empty");
      ValidationUtils.rejectIfEmpty(err, "lastName", "student.lastName.empty");

      Student student = (Student) obj;

      Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);
      if (!(pattern.matcher(student.getEmail()).matches()) && Pattern.compile("\\S+", Pattern.CASE_INSENSITIVE).matcher(student.getEmail()).matches()) {
         err.rejectValue("email", "student.email.invalid");
      }

   }

}
