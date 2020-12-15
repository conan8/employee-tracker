package com.bartekdobo.web.data;

import java.util.ArrayList;
import java.util.List;

import com.bartekdobo.web.model.Employee;

public class EmployeeData {
	
	public List<Employee> getEmployees() {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee(1,"Jan", "Kowalski", "jakkowalski@onet.poczta.pl"));
		employees.add(new Employee(2,"Stan", "Manecki", "stanmanecki@gmail.com"));
		employees.add(new Employee(3,"Jacek", "Nowak", "jackowal@wp.pl"));
		employees.add(new Employee(4,"Kacper", "Bober", "kbober@onet.poczta.pl"));
		employees.add(new Employee(5,"Tomasz", "Klich", "tomaszklich@wp.pl"));
		employees.add(new Employee(6,"Aleksandra", "Holecka", "aleholecka@gmail.coml"));
		employees.add(new Employee(7,"Maciej", "Stojanowski", "stojanmac@onet.poczta.pl"));
		employees.add(new Employee(8,"Karolina", "Manowska", "karomano@onet.gmail.com"));
		employees.add(new Employee(9,"Monika", "Kropka", "kropkamonika@wp.pl"));
		
		return employees;
	}

}
