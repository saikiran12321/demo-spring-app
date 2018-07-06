package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmployeeDAO;
import com.spring.entity.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	@Override
	@Transactional
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees();
	}
	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
			
		employeeDAO.saveEmployee(theEmployee);
		
	}
	@Override
	@Transactional
	public Employee getEmployee(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(theId);
	}
	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		employeeDAO.deleteEmployee(theId);
		
	}

}
