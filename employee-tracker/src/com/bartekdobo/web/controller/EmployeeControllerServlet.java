package com.bartekdobo.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bartekdobo.web.approximatematching.ApproximateMatcher;
import com.bartekdobo.web.approximatematching.ApproximateMatcherFactory;
import com.bartekdobo.web.data.EmployeeData;
import com.bartekdobo.web.model.Employee;
import com.bartekdobo.web.utils.StringUtils;

/**
 * Servlet implementation class EmployeeControllerServlet
 */
@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final int UPDATE_ADD_MATCH = 1;
	private static final int UPDATE_REMOVE_MATCH = 2;
	private static final int UPDATE_ADD_NO_MATCH = 3;
	private static final int UPDATE_REMOVE_NO_MATCH = 4;
	
	EmployeeData employeeData;
	ApproximateMatcher matcher;
		
	@Override
	public void init() throws ServletException {
		super.init();
		
		employeeData = EmployeeData.getInstance();
		
		matcher = ApproximateMatcherFactory.getApproximateMatcher("levenshtein");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			String command = request.getParameter("command");
			
			if(command == null) {
				command = "LIST";
			}
			
			switch(command) {
				case "LIST":
					listEmployees(request, response);
					break;
				case "ADD":
					addEmployee(request, response);
					break;					
				case "REMOVE":
					removeEmployee(request, response);
					break;
				default:
					listEmployees(request, response);
			}
			
		} 
		catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Employee> employees = employeeData.getEmployees();
		
		request.setAttribute("employee_list", employees);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employees.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		String fullname = StringUtils.createFullName(firstname, lastname);
		
		Employee newEmployee = new Employee(firstname, lastname, email);
		
		// approximate check before adding new employee
		List<String> approximateMatches =  matcher.verify(fullname, employeeData.getFullNames());
		
		if(null == approximateMatches || approximateMatches.size() == 0) {
			employeeData.addEmployee(newEmployee);
			request.setAttribute("update", UPDATE_ADD_NO_MATCH);
		} else {
			request.setAttribute("fullname", fullname);
			request.setAttribute("approximate_matches_list", approximateMatches);
			request.setAttribute("update", UPDATE_ADD_MATCH);
		}
		
		listEmployees(request, response);
	}
	
	private void removeEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		// approximate check before removing employee
		List<String> approximateMatches =  matcher.verify(email, employeeData.getEmails());
		
		if(null == approximateMatches || approximateMatches.size() == 0) {
			request.setAttribute("update", UPDATE_REMOVE_NO_MATCH);
		} else {
			employeeData.removeEmployee(email, approximateMatches);
			request.setAttribute("email", email);
			request.setAttribute("approximate_matches_list", approximateMatches);
			request.setAttribute("update", UPDATE_REMOVE_MATCH);
		}
		
		listEmployees(request, response);
	}

}
