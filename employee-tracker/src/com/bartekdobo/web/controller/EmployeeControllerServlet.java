package com.bartekdobo.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bartekdobo.web.data.EmployeeData;
import com.bartekdobo.web.model.Employee;

/**
 * Servlet implementation class EmployeeControllerServlet
 */
@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeData employeeData;
		
	@Override
	public void init() throws ServletException {
		super.init();
		
		employeeData = new EmployeeData();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			listEmployees(request, response);
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

}
