package com.employee.service;

import org.springframework.stereotype.Component;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;

@Component
public interface EmployeeService 
{ 
  Employee registerEmployee(Employee employee);
  
  Employee login(String email,String password);
  
  Employee findByEmail(String emial);
  
  void updatePassword(String email,String password);
}
