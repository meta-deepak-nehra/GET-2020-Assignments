package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 * Controller class for communication between client and service layer.
 */
@Controller
public class EmployeeController extends ValidateSession{
	
	double USD = 0.013, YEN = 1.54 ;
	
	@Autowired
	private EmployeeService employeeService;
	
	public static String uploadDirectory = System.getProperty("user.dir")+"\\src\\main\\resources\\static";
	/**
	 * Function to add employee(GET request).
	 * @param model contains the request data and provides it to view page.
	 * @param session for a particular employee.
	 * @return Returning the vehicle registration form
	 */
	@GetMapping("/vehicleRegistration")
	public String addEmployee(Model model, HttpSession session) {
		Vehicle vehicle = new Vehicle();
		vehicle.setEmpId((int)session.getAttribute("empId"));
		model.addAttribute("vehicle",vehicle);
		System.out.println("vehicle");
		return "vehicleRegistration";
	}
	/**
	 * Function for vehicle registration(POST request).
	 * @param vehicle object to add a vehicle.
	 * @param errors to catch the error.
	 * @param model contains the request data and provides it to view page.
	 * @param session for a particular employee.
	 * @param bindingResult to show the results to the user.
	 * @return Returns us the getPass page.
	 * @throws SQLException which we get while putting the data. 
	 */
	@PostMapping("/vehicleRegistration")
	public String login(@Valid @ModelAttribute("vehicle") Vehicle vehicle, Model model, HttpSession session, Errors errors, BindingResult bindingResult) throws SQLException {
		double Daily = 0.0, Monthly = 0.0, Yearly = 0.0;
		String heading = null;
		
		if(errors.hasErrors()) {
			System.out.println("errors");
			return "vehicleRegistration";
		}else {
			employeeService.addVehicle(vehicle);
			System.out.println("employee valid");
			
			if("Cycle".equals(vehicle.getVehicleType())){
	            heading = "Cycle Pass";
	            Daily = 5;
	            Monthly = 100;
	            Yearly = 500;
	        }
	        else if("MotorCycle".equals(vehicle.getVehicleType())){
	            heading = "MotorCycle Pass";
	            Daily = 10;
	            Monthly = 200;
	            Yearly = 1000;
	        }
	        else if("Four Wheelers".equals(vehicle.getVehicleType())){
	            heading = "Four Wheelers Pass";
	            Daily = 20;
	            Monthly = 500;
	            Yearly = 3500;
	        }
	        if("USD".equals(vehicle.getCurrency())){
	            Daily = Daily * USD;
	            Monthly = Monthly * USD ;
	            Yearly = Yearly * USD;
	        }
	        else if("YEN".equals(vehicle.getCurrency())){
	            Daily = Daily * YEN;
	            Monthly = Monthly * YEN;
	            Yearly = Yearly * YEN;
	        }
			
			System.out.println(Daily+" "+Monthly+" "+Yearly);
			session.setAttribute("passType", heading);
			session.setAttribute("Daily", Daily);
			session.setAttribute("Monthly", Monthly);
			session.setAttribute("Yearly", Yearly);
			return "redirect:/getPass";
		}
	}
	/**
	 * Function to get pass(GET request).
	 * @param model contains the request data and provides it to view page.
	 * @param session for a particular employee.
	 * @return Returns us the getPass page.
	 */
	@GetMapping("/getPass")
	public String getPass(Model model, HttpSession session) {
		model.addAttribute("getPassModel",new GetPassModel());
		model.addAttribute("passType",session.getAttribute("passType"));
		model.addAttribute("Monthly",session.getAttribute("Momthly"));
		model.addAttribute("Daily",session.getAttribute("Daily"));
		model.addAttribute("Yearly",session.getAttribute("Yearly"));
		System.out.println("getPass");
		return "getPass";
	}
	/**
	 * Function to get pass(POST request).
	 * @param getPassModel is a pass model from which we have to select pass.
	 * @param errors to catch the error.
	 * @param session for a particular employee.
	 * @param model contains the request data and provides it to view page.
	 * @param bindingResult to show the results to the user.
	 * @return Returns the home page.
	 * @throws SQLException which we get while putting the data.
	 */
	@PostMapping("/getPass")
	public String getPass(@Valid @ModelAttribute("getPassModel") GetPassModel getPassModel, Errors errors ,HttpSession session, Model model, BindingResult bindingResult) throws SQLException {
		if(errors.hasErrors()) {
			System.out.println("getpass errors");
			return "getPass";
		}
		
		int empId = (int) session.getAttribute("empId");
		getPassModel.setEmpId(empId);
		employeeService.addVehiclePrice(empId, getPassModel.getPrice());
		return "redirect:/home";		
	}
	/**
	 * Function to change password(GET request)
	 * @param model contains the request data and provides it to view page.
	 * @return Returns the page to change password.
	 */
	@GetMapping("/changePassword")
	public String signup(Model model) {
		model.addAttribute("changePasswordModel",new ChangePasswordModel());
		System.out.println("changePasswordModel");
		return "changePassword";
	}
	/**
	 * Function to change password(POST request)
	 * @param changePasswordModel is model class object for changing password.
	 * @param errors to catch the error.
	 * @param bindingResult to show the results to the user.
	 * @param model contains the request data and provides it to view page.
	 * @param session  for a particular employee.
	 * @return Return home if password will be changed else changePassword page.
	 * @throws SQLException SQL exceptions
	 * @throws IOException IO exceptions
	 */
	@PostMapping("/changePassword")
	public String signup(@Valid @ModelAttribute("changePasswordModel") ChangePasswordModel changePasswordModel, Errors errors, BindingResult bindingResult, Model model, HttpSession session) throws SQLException, IOException {
		if(errors.hasErrors()) {
			System.out.println("errors");
			return "changePassword";
		}
		if(changePasswordModel.getNewPassword().equals(changePasswordModel.getConfirmPassword())) {
			if(employeeService.changePassword((int)session.getAttribute("empId"), changePasswordModel.getNewPassword(), changePasswordModel.getOldPassword())) {
				System.out.println("password valid");
				return "redirect:/home";
			}
		}
		return "changePassword";
	}
	/**
	 * Function to update data(GET request).
	 * @param model contains the request data and provides it to view page.
	 * @param session for a particular employee.
	 * @return Return update page to update data.
	 * @throws IOException IO Exception.
	 * @throws SQLException SQL Exception.
	 */
	@GetMapping("/update")
	public String update(Model model, HttpSession session) throws IOException, SQLException {
		model.addAttribute("employee",session.getAttribute("employeeInformation"));
		System.out.println("employeeUpdate");
		return "update";
	}
	/**
	 * Function to update data(POST request).
	 * @param updateModel is model class object for updating data.
	 * @param errors to catch the error.
	 * @param bindingResult to show the results to the user.
	 * @param model contains the request data and provides it to view page.
	 * @return home if data will be updated else updateData page.
	 * @throws SQLException SQL Exception.
	 * @throws IOException IO Exception.
	 */
	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("employee") UpdateModel updateModel, Errors errors, BindingResult bindingResult, Model model) throws SQLException, IOException {
		if(errors.hasErrors()) {
			System.out.println("errors");
			return "update";
		}
		if(employeeService.updateEmployee(updateModel)) {
			System.out.println("employee update");
			return "redirect:/home";
		}
		else
			return "update";
	}
	/**
	 * Function to logout(GET request)
	 * @param model contains the request data and provides it to view page.
	 * @param session for a particular employee.
	 * @return Returns the homePage.
	 */
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("empId");
		System.out.println("employeelogout");
		return "redirect:/home";
	}
	/**
	 * Function to upload image(GET request)
	 * @param model contains the request data and provides it to view page.
	 * @return Returns the image upload page.
	 */
	@GetMapping("/upload")
	public String logout(Model model) {
		System.out.println("img");
		return "ImageUpload";
	}
	/**
	 * Function to upload image(POST request)
	 * @param model contains the request data and provides it to view page.
	 * @param img image which we have to upload.
	 * @param session for a particular employee.
	 * @return Return the home.
	 * @throws IOException IO Exception.
	 * @throws SQLException SQL Exception.
	 */
	@PostMapping("/upload")
	public String upload(Model model, @RequestParam("file") MultipartFile img, HttpSession session) throws IOException, SQLException {
		Path fileNameAndPath = Paths.get(uploadDirectory,img.getOriginalFilename());
		System.out.println(fileNameAndPath);
		Files.write(fileNameAndPath, img.getBytes());
		System.out.println(fileNameAndPath);
		model.addAttribute("msg","ssss");
		System.out.println(fileNameAndPath);
		employeeService.setEmployeeImage((int) session.getAttribute("empId"), img.getOriginalFilename());
		return "redirect:/home";
	}
	
//	@GetMapping("/upload")
//	public String logout(Model model) {
//		System.out.println("img");
//		return "ImageUpload";
//	}
//	
//	@PostMapping("/upload")
//	public String upload(Model model, @RequestParam("file") MultipartFile img, HttpSession session) throws IOException, SQLException {
//		Path fileNameAndPath = Paths.get(uploadDirectory,img.getOriginalFilename());
//		System.out.println(fileNameAndPath);
//		Files.write(fileNameAndPath, img.getBytes());
//		System.out.println(fileNameAndPath);
//		employeeService.setEmployeeImage((int) session.getAttribute("empId"), img.getBytes());
//		return "redirect:/home";
//	}
}
