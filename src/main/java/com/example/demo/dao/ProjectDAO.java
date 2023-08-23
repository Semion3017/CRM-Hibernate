package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;

@Repository
public interface ProjectDAO {
	
	List<Project> getProjects();
	
	Project getProjectById(long id);
	
	void createProjects(Project project);
	
	void updateProjects(long id, Project project);
	
	void deleteProjects(long id);

	List<Project> getProjectsByEmployees(long employeeId);
	
	

}
