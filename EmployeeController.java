package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController 
{
	@Autowired
    private EmployeeService employeeService;
	
	
	// to handle register page
	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute Employee employee,Model model)
	{
		Employee existing = employeeService.findByEmail(employee.getEmail());
		if(existing != null)
		{
			model.addAttribute("error", "Email already registered..!");
			return "register";
		}
		employeeService.registerEmployee(employee);
		model.addAttribute("msg", "Registration succefull...! Please Login");
		return "login";
	}
	
//	@PostMapping("/register")
//	public ResponseEntity<String> registerEmployee(@RequestBody Employee employee) {
//	    Employee existing = employeeService.findByEmail(employee.getEmail());
//	    if (existing != null) {
//	        return ResponseEntity.badRequest().body("Email already registered!");
//	    }
//	    employeeService.registerEmployee(employee);
//	    return ResponseEntity.ok("Registration successful! Please login.");
//	}

	
	// to show register page
	@GetMapping("/showregister")
	public String  showRegisterPage(Model model)
	{
		model.addAttribute("employee", new Employee());
		return "register";
	}
	
	// to show login page
	@GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "login";
    }
	
	 // to handle login page
	@PostMapping("/loginemp")
	public String login(@ModelAttribute Employee employee,HttpSession session, Model model)
	{
		Employee loggedIn = employeeService.login(employee.getEmail(), employee.getPassword());
		if(loggedIn != null)
		{
			session.setAttribute("loggedInUser", loggedIn);
			return "dashboard";
		}
		else
		{
			model.addAttribute("error", "Invalid email or Password");
			return "login";
		}
	}
	
	// to show forgot-password page
	@GetMapping("/forgot-password")
	public String showForgorPasswordPage() 
	{
	  return "forgot-password";
	}
	
	@PostMapping("/forgot-password")
	public String resetPassword(@RequestParam String email, @RequestParam String password, Model model)
	{
		Employee emp= employeeService.findByEmail(email);
		if(emp != null)
		{
			employeeService.updatePassword(email, password);
			model.addAttribute("msg", "Password updated Succefully.! Please Login.");
			return "login";
		}
		else
		{
			model.addAttribute("error", "Email not found.");
			return "forgot-password";
		}
	}
	
	// this is for logout
	 @GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/loginemp";
	}
	 


}
