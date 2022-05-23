package com.sbapijdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sbapijdbc.model.Employee;

@Repository
//@Slf4js
public class EmployeeDAOImpl implements EmployeeDAO {
	
//	private Logger logger=LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Employee emp) {
		return jdbcTemplate.update("insert into TBL_EMPLOYEES(name,email,department) values (?,?,?)",new Object[] {emp.getName(),emp.getEmail(),emp.getDepartment()});
	}

	@Override
	public int delete(int id) {		 
		return jdbcTemplate.update("delete from tbl_employees where id=?",id);
	}

	@Override
	public int update(Employee emp, int id) {
		return jdbcTemplate.update("update tbl_employees set name=?,email=?,department=? where id=?",new Object[] {emp.getName(),emp.getEmail(),emp.getDepartment(),id});
	}

	@Override
	public List<Employee> getAll() {		
		return jdbcTemplate.query("SELECT * FROM tbl_employees", new BeanPropertyRowMapper<Employee>(Employee.class)); 
	}

	@Override
	public Employee getById(int id) {
		
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM `springboot-jdbc`.tbl_employees where id=?",  new BeanPropertyRowMapper<Employee>(Employee.class),id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new Employee();
		}
	}

}
