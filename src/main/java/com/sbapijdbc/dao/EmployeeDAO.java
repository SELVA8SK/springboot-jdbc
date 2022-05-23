package com.sbapijdbc.dao;

import java.util.List;

import com.sbapijdbc.model.Employee;

public interface EmployeeDAO {	
	int save(Employee emp);	
	int delete(int id);	
	int update(Employee emp,int id);
	List<Employee> getAll();
	Employee getById(int id);
}
