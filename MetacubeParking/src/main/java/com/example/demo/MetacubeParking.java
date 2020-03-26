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
/**
 * Controller class for any client request.
 */
@Controller
public class MetacubeParking extends ValidateSession{

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * Function for login mapping(GET request).
	 * @param model which is to be added.
	 * @return Return to login page.
	 */
	@GetMapping({"/","/login"})
	public String addEmployee(Model model) {
		model.addAttribute("LoginModel",new LoginModel());
		return "login";
	}
	
	/**
	 * Function for login mapping(POST request).
	 * @param loginModel LoginModel for taking and mapping the inputs during login.
	 * @param errors To check the errors.
	 * @param bindingResult To bind the results.
	 * @param model which will be logged in.
	 * @param session for a particular user.
	 * @return Login page if input credentials are wrong else returns home page.
	 * @throws SQLException SQL Exception
	 * @throws IOException IO Exception
	 */
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("LoginModel") LoginModel loginModel, Errors errors, BindingResult bindingResult, Model model, HttpSession session) throws SQLException, IOException {
		if (bindingResult.hasErrors()) {

			return "login";
		}
		int empId = employeeService.checkAuthentication(loginModel.getEmailID(),loginModel.getPassword());
		if(empId != 0) {
				session.setAttribute("empId",empId );
				return "redirect:/home";	
		}else {
				return "login";
			}
	}
	
	/**
	 * Function for SignUp mapping(GET request).
	 * @param model which will be used for SignUp.
	 * @return Returns the SignUp page.
	 */
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("employee",new Employee());
		return "signup";
		
	}
	
	/**
	 * Function for SignUp mapping(POST request).
	 * @param employee which will be signed up.
	 * @param errors To check the errors.
	 * @param session for a particular user.
	 * @param bindingResult To bind the results.
	 * @param model which will be signed up.
	 * @return Return home page if employee will be added else SignUp page.
	 * @throws SQLException SQL Exception
	 * @throws IOException IO Exception
	 */
	@PostMapping("/signup")
	public String signup(@Valid @ModelAttribute("employee") Employee employee, Errors errors, HttpSession session, BindingResult bindingResult, Model model) throws SQLException, IOException {
		if(errors.hasErrors()) {
			return "signup";
		}else {
			int empId = employeeService.checkEmailId(employee.getEmailID());
			if(empId == 0) {
				session.setAttribute("empId",employeeService.addEmployee(employee));
				return "redirect:/home";
			}
		}
		return "signup";
	}
	
	/**
	 * Function for mapping the home page. 
	 * @param model who is logged in at present. 
	 * @param session for a particular user.
	 * @param response for the request to the servlet.
	 * @return Return the home page.
	 * @throws IOException IO Exception
	 * @throws SQLException SQL Exception
	 */
	@GetMapping("/home")
	public String home(Model model, HttpSession session, HttpServletResponse response) throws IOException, SQLException {
		if(isSessionValid(session, response)) {
			int empId  = (int)session.getAttribute("empId");
			Employee employee = employeeService.getEmployee(empId);
			model.addAttribute("employee",employee);
			model.addAttribute("employeeFriends",employeeService.getEmployeeFriends(empId));
			session.setAttribute("employeeInformation", employee);
			String imageName = employeeService.getEmployeeImage(empId);
			model.addAttribute("imageName", imageName);
			return "home";
			
		}
		else
			return "redirect:/";
	}
}
