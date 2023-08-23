package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;

@RestController
public class ProjectController {
	
	private final ProjectService  projectService;

	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	// !--------------- Base functionality ----------------------!
	
	@GetMapping(value = "/projects")
    public List<Project> getProjects() {
    	
    	return projectService.getProjects();
    }
	
	@GetMapping(value = "/projects/{id}")
    public Project getProjectById(@PathVariable long id) {
    	
    	return projectService.getProjectById(id);
    }
	
	
	@PostMapping(value = "/projects")
    public ResponseEntity<?> createProjects(@ModelAttribute Project project) {
		projectService.createProjects(project);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PutMapping(value = "/projects/{id}")
    public ResponseEntity<?> updateProjects(@PathVariable long id, @ModelAttribute Project project) {
		projectService.updateProjects(id, project);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@DeleteMapping(value = "/projects/{id}")
    public ResponseEntity<?> deleteProjects(@PathVariable long id) {
		projectService.deleteProjects(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
	
	
	// !------------- Required functionality ----------------------------!
	
	@GetMapping(value = "/projects/employee/{employeeId}")
    public List<Project> getProjectsByEmployees(@PathVariable long employeeId) {
    	
    	return projectService.getProjectsByEmployees(employeeId);
    }

}
