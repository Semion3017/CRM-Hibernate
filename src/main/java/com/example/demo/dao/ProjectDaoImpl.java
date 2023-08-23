package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.util.UtilsHiber;

@Repository
public class ProjectDaoImpl implements ProjectDAO{

	@Override
	public List<Project> getProjects() {
		String query = "select p from Project p";
		try (Session session = UtilsHiber.getSession()) {
			session.beginTransaction();
			List<Project> projectList = session.createQuery(query, Project.class).getResultList();
			session.getTransaction().commit();

			return projectList;
		}
	}

	@Override
	public Project getProjectById(long id) {
		try(Session session = UtilsHiber.getSession()){
			session.beginTransaction();
			Project project = session.get(Project.class, id);
			session.getTransaction().commit();
		return project;
		}
	}

	@Override
	public void createProjects(Project project) {
		try(Session session = UtilsHiber.getSession()){
			session.beginTransaction();
			session.persist(project);
			session.getTransaction().commit();
		}
		
	}

	@Override
	public void updateProjects(long id, Project projectWithUpdates) {
		try(Session session = UtilsHiber.getSession()){
			session.beginTransaction();
			Project projectBeforeUpdate = session.get(Project.class, id);
			if (projectBeforeUpdate == null) {
				session.getTransaction().commit();
			} else {
			if (projectWithUpdates.getTitle() == null)
				projectWithUpdates.setTitle(projectBeforeUpdate.getTitle());
			session.merge(projectWithUpdates);
			session.getTransaction().commit();
			}
	}
		
	}

	@Override
	public void deleteProjects(long id) {
		try (Session session = UtilsHiber.getSession()) {
			session.beginTransaction();
			Project project = session.get(Project.class, id);
			if (project == null) {
				session.getTransaction().commit();
			} else {
				session.remove(project);
				session.getTransaction().commit();
			}
		}
		
	}

	@Override
	public List<Project> getProjectsByEmployees(long employeeId) {
		String query = "select p from Project p join p.employees e where e.id = :employeeId";
		try(Session session = UtilsHiber.getSession()){
				session.beginTransaction();
				List<Project> projectList = session.createQuery(query, Project.class)
						.setParameter("employeeId", employeeId)
						.getResultList();
				session.getTransaction().commit();
			
		return projectList;
		}
	}

}
