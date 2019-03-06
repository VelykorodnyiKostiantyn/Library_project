package data_handling.service;

import java.util.List;

import data_handling.dto.StudentDto;

public interface StudentManager {
	public void addStudent(StudentDto studentDto);
	public void updateStudent(StudentDto studentDto);
	public void deleteStudent(StudentDto studentDto);
	public List<StudentDto> searchStudent(StudentDto studentDto);
	public StudentDto getStudent(int ident);
}
