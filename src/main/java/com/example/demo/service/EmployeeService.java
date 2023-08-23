package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Service;


import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService {

	private final EmployeeDAO employeeDao;

    public EmployeeService(EmployeeDAO employeeDao) {
        this.employeeDao = employeeDao;
    }
    
    public List<Employee> getEmployees(){
		return employeeDao.getEmployees();
    }
    
    public Employee getEmployeeById(long id) {
    	return employeeDao.getEmployeeById(id);
    }
    
    public void createEmployees(Employee employee) {
    	employeeDao.createEmployees(employee);
    }
    
    public void updateEmployees(long id, Employee employeeWithUpdates) {
    	employeeDao.updateEmployees(id, employeeWithUpdates);
    }
    
    public void deleteEmployee(long id) {
    	employeeDao.deleteEmployee(id);
    }

	public void setEmployeeToPost(long employeeId, long postId) {
		employeeDao.setEmployeeToPost(employeeId, postId);
		
	}

	public void setEmployeeToProject(long employeeId, long projectId) {
		employeeDao.setEmployeeToProject(employeeId, projectId);
		
	}

	public List<Employee> getEmployeesByPost(long postId) {
		return employeeDao.getEmployeesByPost(postId);
		
	}

	public List<Employee> getEmployeesByProject(long projectId) {
		return employeeDao.getEmployeesByProject(projectId);
		
	}
    
    
    
}
