package com.example.demo.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Post;
import com.example.demo.entity.Project;
import com.example.demo.util.UtilsHiber;


@Repository
public class EmployeeDaoImpl implements EmployeeDAO{

	@Override
	public List<Employee> getEmployees() {
		String query = "select e from Employee e";
		try(Session session = UtilsHiber.getSession()){
				session.beginTransaction();
				List<Employee> employeeList = session.createQuery(query, Employee.class).getResultList();
				session.getTransaction().commit();
			
		return employeeList;
		}
	}

	@Override
	public Employee getEmployeeById(long id) {
		try(Session session = UtilsHiber.getSession()){
			session.beginTransaction();
			Employee employee = session.get(Employee.class, id);
			session.getTransaction().commit();
		return employee;
		}
	}

	@Override
	public void createEmployees(Employee employee) {
		try(Session session = UtilsHiber.getSession()){
			session.beginTransaction();
			session.persist(employee);
			session.getTransaction().commit();
		}
		
	}

	@Override
	public void updateEmployees(long id, Employee employeeWithUpdates) {
		try(Session session = UtilsHiber.getSession()){
				session.beginTransaction();
				Employee employeeBeforeUpdate = session.get(Employee.class, id);
				if (employeeBeforeUpdate == null) {
					session.getTransaction().commit();
				} else {
				if(employeeWithUpdates.getName() == null) 
					employeeWithUpdates.setName(employeeBeforeUpdate.getName());
				if(employeeWithUpdates.getSurname() == null)
					employeeWithUpdates.setSurname(employeeBeforeUpdate.getSurname());
				session.merge(employeeWithUpdates);
				session.getTransaction().commit();
				}
		}
		
	}

	@Override
	public void deleteEmployee(long id) {
		try (Session session = UtilsHiber.getSession()) {
			session.beginTransaction();
			Employee employee = session.get(Employee.class, id);
			if (employee == null) {
				session.getTransaction().commit();
			} else {
				session.remove(employee);
				session.getTransaction().commit();
			}
		}
		
	}

	@Override
	public void setEmployeeToPost(long employeeId, long postId) {
		try (Session session = UtilsHiber.getSession()) {
			session.beginTransaction();
			Employee employee = session.get(Employee.class, employeeId);
			Post post = session.get(Post.class, postId);
			if (employee == null) {
				session.getTransaction().commit();
			} else if(post == null) {
				session.getTransaction().commit();
			} else {
				employee.setPost(post);
				session.getTransaction().commit();
			}
		}
		
	}

	@Override
	public void setEmployeeToProject(long employeeId, long projectId) {
		try (Session session = UtilsHiber.getSession()) {
			session.beginTransaction();
			Employee employee = session.get(Employee.class, employeeId);
			Project project = session.get(Project.class, projectId);
			if (employee == null) {
				session.getTransaction().commit();
			} else if(project == null) {
				session.getTransaction().commit();
			} else {
				employee.getProjects().add(project);
				session.merge(employee);
				session.getTransaction().commit();
			}
		}
		
	}

	@Override
	public List<Employee> getEmployeesByPost(long postId) {
		String query = "select e from Employee e where post.id = :postId ";
		try(Session session = UtilsHiber.getSession()){
				session.beginTransaction();
				List<Employee> employeeList = session.createQuery(query, Employee.class)
						.setParameter("postId", postId)
						.getResultList();
				session.getTransaction().commit();
			
		return employeeList;
		}
	}

	@Override
	public List<Employee> getEmployeesByProject(long projectId) {
		String query = "select e from Employee e join e.projects p where p.id = :projectId";
		try(Session session = UtilsHiber.getSession()){
				session.beginTransaction();
				List<Employee> employeeList = session.createQuery(query, Employee.class)
						.setParameter("projectId", projectId)
						.getResultList();
				session.getTransaction().commit();
			
		return employeeList;
		}
	}
	

}
