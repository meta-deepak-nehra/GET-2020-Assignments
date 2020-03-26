package com.example.demo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MetacubeParking extends ValidateSession{

	@Autowired
	private EmployeeService employeeService;

	
	@GetMapping({"/","/loginuser"})
	public String addEmployee(Model model) {
		model.addAttribute("LoginModel",new LoginModel());
		System.out.println("employee login");
		return "loginuser";
	}
	
	@PostMapping("/loginuser")
	public String login(@Valid @ModelAttribute("LoginModel") LoginModel loginModel, Errors errors, BindingResult bindingResult, Model model, HttpSession session) throws SQLException, IOException {
		if (bindingResult.hasErrors()) {
			System.out.println("aaya1 "+errors.hasErrors());
			System.out.println(loginModel.getEmailID()+" "+loginModel.getPassword());

			return "loginuser";
		}
		System.out.println("aaya");
		int empId = employeeService.checkAuthentication(loginModel.getEmailID(),loginModel.getPassword());
		if(empId != 0) {
				System.out.println("valid");
				session.setAttribute("empId",empId );
				session.setAttribute("employee",employeeService.getEmployee(empId));
				return "redirect:/home";	
		}else {
				System.out.println("invalid");
				return "loginuser";
			}
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("employee",new Employee());
		System.out.println("employee singup");
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid @ModelAttribute("employee") Employee employee, HttpSession session, Errors errors, BindingResult bindingResult, Model model) throws SQLException, IOException {
		if(errors.hasErrors()) {
			System.out.println("errors");
			return "signup";
		}else {
			int empId = employeeService.checkEmailId(employee.getEmailID());
			if(empId == 0) {
				System.out.println("add");
				session.setAttribute("empId",employeeService.addEmployee(employee));
				System.out.println((int)session.getAttribute("empId"));
				session.setAttribute("employee",employeeService.getEmployee(empId));
				return "home";
			}
		}
		System.out.println("employee valid");
		return "signup";
	}
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session, HttpServletResponse response) throws IOException, SQLException {
		if(isSessionValid(session, response)) {
			int empId  = (int)session.getAttribute("empId");
			Employee employee = employeeService.getEmployee(empId);
			model.addAttribute("employee",employee);
			model.addAttribute("employeeFriends",employeeService.getEmployeeFriends(empId));
			session.setAttribute("employeeInformation", employee);
			System.out.println("session valid");
			String imageName = employeeService.getEmployeeImage(empId);
			model.addAttribute("imageName", imageName);
			return "home";
			
		}
		else
			return "redirect:/loginuser";
	}
}
