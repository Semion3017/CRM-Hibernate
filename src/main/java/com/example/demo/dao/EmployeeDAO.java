package com.example.demo.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeDAO {
	
	List<Employee> getEmployees();
	
	Employee getEmployeeById(long id);
	
	void createEmployees(Employee employee);
	
	void updateEmployees(long id, Employee employeeWithUpdates);
	
	void deleteEmployee(long id);

	void setEmployeeToPost(long employeeId, long postId);

	void setEmployeeToProject(long employeeId, long projectId);

	List<Employee> getEmployeesByPost(long postId);

	List<Employee> getEmployeesByProject(long projectId);

}
