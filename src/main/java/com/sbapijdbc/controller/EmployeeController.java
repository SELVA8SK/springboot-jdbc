package com.sbapijdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbapijdbc.dao.EmployeeDAO;
import com.sbapijdbc.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return employeeDAO.getAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable ("id") int id){
		return employeeDAO.getById(id);
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee emp){
		return employeeDAO.save(emp) +" No. of rows saved.";
	}
	
	@PutMapping("/employee/{id}")
	public String updateEmployee(@RequestBody Employee emp, @PathVariable ("id") int id){
		return employeeDAO.update(emp,id) +" No. of rows updated.";
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable ("id") int id){
		return employeeDAO.delete(id) +" has been deleted.";
	}


}
