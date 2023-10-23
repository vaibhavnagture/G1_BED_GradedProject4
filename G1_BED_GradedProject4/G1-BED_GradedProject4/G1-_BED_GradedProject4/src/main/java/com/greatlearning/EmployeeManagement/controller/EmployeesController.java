package com.greatlearning.EmployeeManagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.EmployeeManagement.service.EmployeeService;
import com.greatlearning.EmployeeManagement.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/add")
	public String add(Model model) {

		// create model attribute to bind form data
		Employee employee = new Employee();

		model.addAttribute("Employee", employee);

		return "update-employee";
	}

	@RequestMapping("/list")
	public String listEmployees(@RequestParam(defaultValue = "") String sort, Model model) {

		// get Employees from DB
		List<Employee> employees = employeeService.findAll(sort);

		// add to the spring model
		model.addAttribute("Employees", employees);

		return "list-employees";
	}

	@RequestMapping("/view")
	public String view(@RequestParam("employeeId") int id, Model model) {

		// get the Employee from the service
		Employee employee = employeeService.findById(id);

		// set Employee as a model attribute to view on the page
		model.addAttribute("Employee", employee);

		// send over to our page
		return "view-employee";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("employeeId") int id, Model model) {

		// get the Employee from the service
		Employee employee = employeeService.findById(id);

		// set Employee as a model attribute to pre-populate the form
		model.addAttribute("Employee", employee);

		// send over to our form
		return "update-employee";
	}

	@PostMapping("/save")
	public String saveEmployee(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		System.out.println(id);
		Employee employee;
		if (id != 0) {
			employee = employeeService.findById(id);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
		} else
			employee = new Employee(firstName, lastName, email);
		// save the Employee
		employeeService.save(employee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {

		// delete the Employee
		employeeService.deleteById(id);

		// redirect to /employees/list
		return "redirect:/employees/list";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("firstName") String firstName, Model model) {

		// check names, if both are empty then just give list of all Employees

		if (firstName.trim().isEmpty()) {
			return "redirect:/employees/list";
		}
		// else, search by first name
		List<Employee> employees = employeeService.searchBy(firstName);

		// add to the spring model
		model.addAttribute("Employees", employees);

		// send to list-employees
		return "list-employees";
	}

	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView modelAndView = new ModelAndView();

		if (user != null) {
			modelAndView.addObject("msg", "Hi " + user.getName() + ", you don't have permission to access this page!");
		} else {
			modelAndView.addObject("msg", "You don't have permission to access this page!");
		}
		modelAndView.setViewName("403");
		return modelAndView;
	}
}
