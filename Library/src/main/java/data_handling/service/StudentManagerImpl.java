package data_handling.service;

import java.util.ArrayList;
import java.util.List;

import data_handling.model.Student;
import data_handling.dao.StudentDAO;
import data_handling.dto.BookDto;
import data_handling.dto.StudentDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentManagerImpl implements StudentManager {
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private ModelDtoMapper mapper;
	
	@Override
	@Transactional
	public void addStudent(StudentDto studentDto) {
		studentDAO.addStudent(mapper.studentToModel(studentDto));
	}
	@Override
	@Transactional
	public void updateStudent(StudentDto studentDto) {
		try {
			System.out.println(studentDto.getFirstName() + " " + studentDto.getLastName() + " " + studentDto.getEmail());
			if (studentDto.getBooks() != null) {
				for (BookDto b : studentDto.getBooks()) {
					System.out.println(b.getIdent() + " " + b.getTitle() + " " + b.getAuthor() + " " + b.getBorrowerId() + " " + b.getBorrowerFirstName() + " " + b.getBorrowerLastName());	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		studentDAO.updateStudent(mapper.studentToModel(studentDto));
	}
	@Override
	@Transactional
	public void deleteStudent(StudentDto studentDto) {
		studentDAO.deleteStudent(mapper.studentToModel(studentDto));
	}
	@Override
	@Transactional
	public List<StudentDto> searchStudent(StudentDto studentDto){
		List<StudentDto> students = new ArrayList<StudentDto>();
		for (Student s: studentDAO.searchStudent(mapper.studentToModel(studentDto))) {
			students.add(mapper.studentToDto(s));
		}
		return students;
	}
	@Override
	@Transactional
	public StudentDto getStudent(int ident) {
		return mapper.studentToDto(studentDAO.getStudent(ident));
	}

}
