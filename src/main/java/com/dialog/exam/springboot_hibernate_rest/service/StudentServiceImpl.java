package com.dialog.exam.springboot_hibernate_rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.dialog.exam.springboot_hibernate_rest.dao.StudentDao;
import com.dialog.exam.springboot_hibernate_rest.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;

	@Override
	public List<Student> getAllStudents() {

		return (List<Student>) studentDao.findAll();
	}

	@Override
	public Optional<Student> getStudentById(Integer studentId) {

		return studentDao.findById(studentId);
	}

	@Override
	public Student createStudent(Student student) {

		return studentDao.save(student);
	}

	@Override
	public Student updateStudent(Student student, Integer studentId) {

		Student exsistingStudent = ((Optional<Student>) studentDao.findById(studentId)).get();
		Assert.notNull(exsistingStudent, "Student not available");
		
		if (student.getName() != null) {
			exsistingStudent.setName(student.getName());
		}
		if (student.getAge() != null) {
			exsistingStudent.setAge(student.getAge());
		}
		if (student.getTelephone() != null) {
			exsistingStudent.setAge(student.getTelephone());
		}	
		return studentDao.save(exsistingStudent);
	}

	@Override
	public void deleteStudent(Integer studnetId) {

		studentDao.deleteById(studnetId);
	}

}
