package com.employee.dto;

import java.time.LocalDate;

public class EmployeeDto {
    private String firstName;
    private String lastName;
    private int salary;
    private String email;
    private String password; // ✅ Make sure this exists
    private LocalDate hiredate;
    private String designation;

    // ✅ Ensure getters and setters exist
    public String getPassword() {
        return password;
    }

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getHiredate() {
		return hiredate;
	}

	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setPassword(String password) {
        this.password = password;
    }

}

