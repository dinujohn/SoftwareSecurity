package com.asu.ss;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class UserDaoImpl  implements UserDao{
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	public User getUser(String emailId) {
		
			System.out.println("Inside DAO");
			User user = (User)jdbcTemplate.queryForObject(this.user_select, 
				new Object[]{emailId}, 
				new RowMapper(){

					public Object mapRow(ResultSet rs, int arg1)
							throws SQLException {
						User u = new User();
						u.setFirstName(rs.getString("firstName"));
						u.setLastName(rs.getString("lastName"));
						
						System.out.println(">><<"+rs.getString("emailId"));
						u.setEmailId(rs.getString("emailId"));
						u.setUserId(rs.getInt("userId"));
						u.setPassword(rs.getString("password"));
						return u;
					}
			
		});
		return user;
	}

	public void saveUser(User user) {
		this.jdbcTemplate.update(this.user_insert, new Object[]{user.getEmailId(),user.getFirstName(),user.getLastName()});
				
	}			
	

	public void updateUser(User user) {
		//this.jdbcTemplate.update(this.employee_update, new Object[]{e.getEmployeeName(), e.getEmployeeDept(), e.getEmailId(), new Integer(e.getEmpId())} );
		
	}
	
	private final String user_select = "SELECT * FROM USER WHERE emailId= ?";
	private final String user_insert = "INSERT INTO USER( EmailID,FirstName,LastName) VALUES(?,?,?)";
	private final String employee_update = "UPDATE EMPLOYEE SET EMP_NAME=?, EMP_DEPT=?,EMP_EMAILID=? WHERE EMP_ID = ?" ;

}
