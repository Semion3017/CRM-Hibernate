package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;


@RestController
public class EmployeeController {
	
	private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    
    // !--------------- Base functionality ----------------------!

    @GetMapping(value = "/employees")
    public List<Employee> getEmployees() {
    	
    	return employeeService.getEmployees();
    }
    
    @GetMapping(value = "/employees/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
    	
    	return employeeService.getEmployeeById(id);
    }
    
    @PostMapping(value = "/employees")
    public ResponseEntity<?> createEmployees(@ModelAttribute Employee employee) {
    	employeeService.createEmployees(employee);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<?> updateEmployees(@PathVariable long id, @ModelAttribute Employee employee) {
    	employeeService.updateEmployees(id, employee);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<?> deleteEmployees(@PathVariable long id) {
    	employeeService.deleteEmployee(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    
    
    // ! ----------- Relation functionality  ---------------------------!
    
    @PutMapping(value = "/employees/{employeeId}/posts/{postId}")
    public ResponseEntity<?> setEmployeeToPost(@PathVariable long employeeId, @PathVariable long postId) {
    	employeeService.setEmployeeToPost(employeeId, postId);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping(value = "/employees/{employeeId}/projects/{projectId}")
    public ResponseEntity<?> setEmployeeToProject(@PathVariable long employeeId, @PathVariable long projectId) {
    	employeeService.setEmployeeToProject(employeeId, projectId);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    
    // !------------- Required functionality ----------------------------!
    
    @GetMapping(value = "/employees/posts/{postId}")
    public List<Employee> getEmployeesByPost(@PathVariable long postId) {
    	
    	return employeeService.getEmployeesByPost(postId);
    }
    
    @GetMapping(value = "/employees/projects/{projectId}")
    public List<Employee> getEmployeesByProject(@PathVariable long projectId) {
    	
    	return employeeService.getEmployeesByProject(projectId);
    }

}
