package com.example.demo.model;

public class Employee {

	private Integer employeeId;
	private String fristName;
	private String lastName;
	private Integer saraly;
	
	public Employee(Integer employee, String fristName, String lastName, Integer salaly) {
		super();
		this.employeeId = employee;
		this.fristName = fristName;
		this.lastName = lastName;
		this.saraly = saraly;
	}
	public Employee() {
		super();
	}
	public Integer getEmployee() {
		return employeeId;
	}
	public void setEmployee(Integer employee) {
		this.employeeId = employee;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getSalaly() {
		return saraly;
	}
	public void setSalaly(Integer saraly) {
		this.saraly = saraly;
	}
	
	
}
