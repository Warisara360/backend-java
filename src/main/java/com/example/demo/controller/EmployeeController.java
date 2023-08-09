package com.example.demo.controller;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	private List<Employee> data = new ArrayList<Employee>();	
	
	@GetMapping("/employee")
	public List<Employee> getEmployee(){
		return employeeRepository.findAll();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee body) {
		
		try {
			Employee employee = employeeRepository.save(body);
			return new ResponseEntity<>(employee, HttpStatus.CREATED);	
		}catch (Exception e){
			return new ResponseEntity<>("Internal server error", HttpStatus.CREATED);
		}
	}
		
	
		@GetMapping("/employee/{employeeId}")
		public ResponseEntity<Object> getEmployeeDetail(@PathVariable Integer employeeId) {
			
		 try {
			 Optional<Employee> employee = employeeRepository.findById(employeeId);
			 if(employee.isPresent()) {
				 return new ResponseEntity<>(employee, HttpStatus.OK);
		 }else {
			 return new ResponseEntity<> ("Employee not found", HttpStatus.BAD_REQUEST);
			 }
		 }catch (Exception e){
				return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
		
		@PutMapping("/employee/{employeeId}")
			public ResponseEntity<Object> updateEmployee(@PathVariable Integer employeeId,@RequestBody Employee body) {
			
			try {
				Optional<Employee> employee = employeeRepository.findById(employeeId);
				if (employee.isPresent()) {
					Employee employeeEdit= employee.get();
					employeeEdit.setFristName(body.getFristName());
					employeeEdit.setLastName(body.getLastName());
					employeeEdit.setSaraly(body.getSaraly());
					employeeEdit.setEmployeeId(body.getEmployeeId());
					
					employeeRepository.save(employee.get());
					
					return new ResponseEntity<>(employeeEdit , HttpStatus.OK);
				}else {
					return new ResponseEntity<>("Employee not found", HttpStatus.BAD_REQUEST);
				}
			}catch (Exception e) {
				return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		
		@DeleteMapping("/employee/{employeeId}")
		public ResponseEntity<Object> deleteEmployee(@PathVariable Integer employeeId) {
		
			try {
				Optional<Employee> employee = employeeRepository.findById(employeeId);
				
			if (employee.isPresent()) {
				employeeRepository.delete(employee.get());
				return new ResponseEntity<>("DELETE SUCSESS", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("Employee not fond",HttpStatus.BAD_REQUEST);
			}
			}catch (Exception e) {
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

		}}
