package com.example.demo.model;

public class Employee {

	private Integer employeeId;
	private String fristName;
	private String lastName;
	private Integer saraly;
	
	public Employee(Integer employeeId, String fristName, String lastName, Integer salaly) {
		super();
		this.employeeId = employeeId;
		this.fristName = fristName;
		this.lastName = lastName;
		this.saraly = saraly;
	}
	public Employee() {
		super();
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getSaraly() {
		return saraly;
	}
	public void setSaraly(Integer saraly) {
		this.saraly = saraly;
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
	
}
