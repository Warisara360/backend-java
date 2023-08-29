package com.example.demo.controller;

import java.util.ArrayList;
import java.awt.Robot;
import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.Student;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	private List<Student>data = new ArrayList<Student>();
	
	@GetMapping("/studens")
	public ResponseEntity<Object> getStudent(){
		try {

			List<Student> students = studentRepository.findAll();
					return new ResponseEntity<> (students,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<> ("Internal sever error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/students")
	public ResponseEntity<Object> addStudent(@RequestBody Student body) {
		
		try {
		    Student student = studentRepository.save(body);
			return new ResponseEntity<>(student, HttpStatus.CREATED);	
			
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@GetMapping("/students/{studentId}")
	public ResponseEntity<Object> getEmployeeDetail(@PathVariable Integer  stuId) {
		
	 try {
		 Optional<Student> student = studentRepository.findById(stuId);
		 if(student.isPresent()) {
			 return new ResponseEntity<>(student, HttpStatus.OK);
	 }else {
		 return new ResponseEntity<> ("Employee not found", HttpStatus.BAD_REQUEST);
		 }
	 }catch (Exception e){
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
		
		@PutMapping("/students/{studentId}")
			public ResponseEntity<Object> updateStudent(@PathVariable Integer student,@RequestBody Student body) {
			
			try {

				Optional<Student> student = studentRepository.findById(stuId);
				if (student.isPresent()) {
					Student studentEdit= student.get();
					studentEdit.setFristName(body.getFristName());
					studentEdit.setLastName(body.getLastName());
					studentEdit.setEmail(body.getEmail());
					studentEdit.setStuId(body.getStuId());

					
					studentRepository.save(student.get());
					
					return new ResponseEntity<>(student , HttpStatus.OK);
				}else {
					return new ResponseEntity<>("Student not found", HttpStatus.BAD_REQUEST);
				}
			}catch (Exception e) {
				return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		
		@DeleteMapping("/students/{studentId}")
		public ResponseEntity<Object> deleteStudent(@PathVariable Integer stuId) {
		
			try {
				Optional<Student> student = studentRepository.findById(stuId);
				
			if (student.isPresent()) {
				studentRepository.delete(student.get());
				return new ResponseEntity<>("DELETE SUCSESS", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("Student not fond",HttpStatus.BAD_REQUEST);
			}
			}catch (Exception e) {
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		}
			public StudentRepository getStudentRepository() {
				return studentRepository;
			}

			public void setStudentRepository (StudentRepository studentRepository) {
				this.studentRepository = studentRepository;
			}
			public List<Student> getData() {
				return data;
			}

			public void setData(List<Student> data) {
				this.data = data;
			
	
			}
}
