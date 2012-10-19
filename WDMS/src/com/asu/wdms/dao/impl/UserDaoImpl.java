package com.asu.wdms.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.asu.wdms.dao.UserDao;
import com.asu.wdms.model.User;


public class UserDaoImpl extends WdmsDaoImpl implements UserDao{
	

	public User getUser(String emailId) {
		
			System.out.println("Inside DAO");
			User user = null;
			
			try{
				user = (User)getJdbcTemplate().queryForObject(this.user_select, 
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
			}catch(EmptyResultDataAccessException  e){
				//TODO log
			}
		return user;
	}

	public void saveUser(User user) {
		this.getJdbcTemplate().update(this.user_insert, new Object[]{user.getEmailId(),user.getFirstName(),user.getLastName(), user.getPassword(),user.getRoleId(), new Integer(1)});
				
	}			
	

	public void updateUser(User user) {
		//this.jdbcTemplate.update(this.employee_update, new Object[]{e.getEmployeeName(), e.getEmployeeDept(), e.getEmailId(), new Integer(e.getEmpId())} );
		
	}
	
	private final String user_select = "SELECT * FROM USER WHERE emailId= ?";
	private final String user_insert = "INSERT INTO USER( EmailID,FirstName,LastName,password,roleID,validUser) VALUES(?,?,?,?,?,?)";
	private final String employee_update = "UPDATE EMPLOYEE SET EMP_NAME=?, EMP_DEPT=?,EMP_EMAILID=? WHERE EMP_ID = ?" ;

}
