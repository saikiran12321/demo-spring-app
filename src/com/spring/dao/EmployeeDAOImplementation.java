package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Employee;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Employee> getEmployees() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Employee> theQuery = session.createQuery("from Employee order by lastName ",Employee.class);
		
		List<Employee> employee = theQuery.getResultList();
		
		return employee;
	}


	@Override
	public void saveEmployee(Employee theEmployee) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theEmployee);
	}


	@Override
	public Employee getEmployee(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Employee.class, theId) ;
	}


	@Override
	public void deleteEmployee(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		Query theQuery = session.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
