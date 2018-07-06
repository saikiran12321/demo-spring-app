package com.spring.services;

import java.util.List;

import com.spring.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployee();

	public void saveEmployee(Employee theCustomer);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);

}
