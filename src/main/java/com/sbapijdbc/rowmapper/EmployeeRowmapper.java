package com.sbapijdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sbapijdbc.model.Employee;

public class EmployeeRowmapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp=new Employee();
		return null;
	}
	
	

}
