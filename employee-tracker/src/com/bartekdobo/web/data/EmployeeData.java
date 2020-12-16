package com.bartekdobo.web.data;

import java.util.ArrayList;
import java.util.List;

import com.bartekdobo.web.model.Employee;
import com.bartekdobo.web.utils.StringUtils;

public class EmployeeData {
	
	private static EmployeeData INSTANCE;
	
	private static List<Employee> employees = new ArrayList<Employee>();
    
    private EmployeeData() {        
    }
    
    public static EmployeeData getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new EmployeeData();
            init();
        }
        
        return INSTANCE;
    }

    private static void init() {		
		employees.add(new Employee(1,"Jan", "Kowalski", "jakkowalski@onet.poczta.pl"));
		employees.add(new Employee(2,"Stan", "Manecki", "stanmanecki@gmail.com"));
		employees.add(new Employee(3,"Jacek", "Nowak", "jackowal@wp.pl"));
		employees.add(new Employee(4,"Kacper", "Bober", "kbober@onet.poczta.pl"));
		employees.add(new Employee(5,"Tomasz", "Klich", "tomaszklich@wp.pl"));
		employees.add(new Employee(6,"Aleksandra", "Holecka", "aleholecka@gmail.coml"));
		employees.add(new Employee(7,"Maciej", "Stojanowski", "stojanmac@onet.poczta.pl"));
		employees.add(new Employee(8,"Karolina", "Manowska", "karomano@onet.gmail.com"));
		employees.add(new Employee(9,"Monika", "Kropka", "kropkamonika@wp.pl"));
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void addEmployee(Employee newEmployee) {
		employees.add(newEmployee);
	}
	
	public List<String> getFullNames() {
		List<String> fullNames = new ArrayList<>();
		
		for (Employee e : employees) {
			fullNames.add(StringUtils.createFullName(e.getFirstname(), e.getLastname()));
		}
		
		return fullNames;
	}

}
