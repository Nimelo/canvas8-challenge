package com.canvas8.service;

import com.canvas8.model.Employee;

import java.util.List;

public interface EmployeeService {

	Employee findById(int id);
	
	void saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployeeBySsn(String ssn);

	List<Employee> findAllEmployees(); 
	
	Employee findEmployeeBySsn(String ssn);

	boolean isEmployeeSsnUnique(Integer id, String ssn);
	
}
