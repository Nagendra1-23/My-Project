package com.employee.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Employee registerEmployee(Employee employee) {
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		return employeeRepository.save(employee);
	}
	
//	public Employee registerEmployee(Employee employee) {
//	    if (employee.getPassword() != null && !employee.getPassword().isEmpty()) {
//	        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
//	        employeeRepository.save(employee);
//	    } else {
//	        throw new IllegalArgumentException("Password must not be null or empty");
//	    }
//		return employee;
//	}
	

//	    public Employee registerEmployee(EmployeeDto dto) {
//	        System.out.println("Received Password: " + dto.getPassword());
//
//	        if (dto.getPassword() == null) {
//	            throw new IllegalArgumentException("Password is missing in request.");
//	        }
//
//	        String encodedPassword = passwordEncoder.encode(dto.getPassword());
//
//	        // Map and save to entity
//	        Employee employee = new Employee();
//	        employee.setFirstName(dto.getFirstName());
//	        employee.setLastName(dto.getLastName());
//	        employee.setPassword(encodedPassword);
//	        employee.setEmail(dto.getEmail());
//	        employee.setSalary(dto.getSalary());
//	        employee.setHiredate(dto.getHiredate());
//	        employee.setDesignation(dto.getDesignation());
//
//	        return employeeRepository.save(employee);
//	    }
	


	@Override
	public Employee login(String email, String rawPassword) 
	{
		Employee employee=employeeRepository.findByEmail(email);
		if(employee != null && passwordEncoder.matches(rawPassword, employee.getPassword()))
		{
			return employee;
		}
		return null;
	}

	@Override
	public Employee findByEmail(String email) 
	{
		return employeeRepository.findByEmail(email);
	}

	@Override
	public void updatePassword(String email, String newPassword) 
	{
        Employee employee= employeeRepository.findByEmail(email);
        if(employee != null)
        {
        	employee.setPassword(passwordEncoder.encode(newPassword));
        	employeeRepository.save(employee);
        }
	}


}
