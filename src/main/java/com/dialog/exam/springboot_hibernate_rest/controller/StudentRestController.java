package com.dialog.exam.springboot_hibernate_rest.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dialog.exam.springboot_hibernate_rest.model.Student;
import com.dialog.exam.springboot_hibernate_rest.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/student")
@Api(value="/student", produces="application/json")
public class StudentRestController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/getAll", produces="application/json", method=RequestMethod.GET)
	@ApiOperation(value = "Find All Students", response=Student.class)
	@ApiResponses({
		@ApiResponse(code=200, message="get all students"),
		@ApiResponse(code=500, message="server error occured")
	})
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json", consumes="application/json")
	@ApiOperation(value = "Create New Student", response = Student.class)
	@ApiResponses({
		@ApiResponse(code=201, message="student created"),
		@ApiResponse(code=400, message="bad request body"),
		@ApiResponse(code=500, message="server error occured")
	})
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		
		Student persistedStudent = studentService.createStudent(student);
		return new ResponseEntity<Student>(persistedStudent, HttpStatus.CREATED);	
	}
	
	@RequestMapping(value="/{studentId}", method=RequestMethod.GET, produces="application/json")
	@ApiOperation(value="Get Student", response=Student.class)
	@ApiResponses({
		@ApiResponse(code=200, message="student found"),
		@ApiResponse(code=404, message="student not fount"), 
		@ApiResponse(code=500, message="internal server error")
	})
	public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
		Optional<Student> student = studentService.getStudentById(studentId);
		return new ResponseEntity<Student>(student.get(), HttpStatus.OK);		
	}
	
	@RequestMapping(value="/{studentId}", consumes="application/json", produces="application/json", method=RequestMethod.PUT)
	@ApiOperation( value = "update student", response=Student.class)
	@ApiResponses({
		@ApiResponse(code=202, message="updated successfully"),
		@ApiResponse(code=404, message="student not found"),
		@ApiResponse(code=500, message="internal server error")
	})
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer studentId) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, studentId), HttpStatus.ACCEPTED);		
	}
}
