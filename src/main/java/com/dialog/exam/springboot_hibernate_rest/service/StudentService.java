package com.dialog.exam.springboot_hibernate_rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dialog.exam.springboot_hibernate_rest.model.Student;

/**
 * 
 * @author mchat
 *
 */
public interface StudentService {

	public List<Student> getAllStudents();
	
	Optional<Student> getStudentById(Integer studentId);
	
	Student createStudent(Student student);
	
	Student updateStudent(Student student, Integer studentId);
	
	void deleteStudent(Integer studnetId);
	
}
