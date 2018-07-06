package com.spring.dao;

import java.util.List;

import com.spring.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();

	public void saveEmployee(Employee theCustomer);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);

}
