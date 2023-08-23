package com.example.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.ProjectDAO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;

@Service
public class ProjectService {

	private final ProjectDAO  projectDao;

	public ProjectService(ProjectDAO projectDao) {
		this.projectDao = projectDao;
	}
	
	
	public List<Project> getProjects() {
    	return projectDao.getProjects();
    }
	
	public Project getProjectById(long id) {    	
    	return projectDao.getProjectById(id);
    }
	
	public void createProjects(Project project) {
		projectDao.createProjects(project);
    }
	
	public void updateProjects(long id, Project project) {
		projectDao.updateProjects(id, project);
    }
	
	public void deleteProjects(long id) {
		projectDao.deleteProjects(id);
    }


	public List<Project> getProjectsByEmployees(long employeeId) {
		return projectDao.getProjectsByEmployees(employeeId);
	}
	
}
