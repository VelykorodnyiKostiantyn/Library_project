package data_handling.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import data_handling.model.Book;


@Component
public class BookValidator implements Validator {

   @Override
   public boolean supports(Class<?> c) {
      return Book.class.equals(c);
   }

   @Override
   public void validate(Object obj, Errors err) {
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "title", "book.title.empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "author", "book.author.empty");
   }

}
