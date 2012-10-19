package com.asu.wdms.test;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.asu.wdms.dao.UserDao;
import com.asu.wdms.dao.UserRequestDao;
import com.asu.wdms.model.User;
import com.asu.wdms.model.UserRequest;



public class UserExec {
	
	
	public static void main(String[] args) {
	
		ApplicationContext ctx = new FileSystemXmlApplicationContext("WebContent/WEB-INF/dispatcher-servlet.xml");
		UserDao userDao = (UserDao)ctx.getBean("userDao");
	/*	User user = new User();
		user.setEmailId("djohn7@asu.edu");
		user.setFirstName("Dinu");
		user.setLastName("John");
		
		userDao.saveUser(user);*/
		
		//getting the data 
		User user1 =userDao.getUser("user1@org.co");
		
		System.out.println("Employee name :"+user1.getFirstName());
		System.out.println("Employee email :"+user1.getEmailId());
		//System.out.println("Employee department:"+emp.getEmployeeDept());
		
		UserRequestDao userRequestDao = (UserRequestDao)ctx.getBean("UserRequestDao");
		
		List<UserRequest> request = userRequestDao.getAllRequest();
		for(UserRequest req: request){
			System.out.println(req.getComment());
		}
		
		JSONObject json = new JSONObject();
		json.put("firstName","test");
		json.put("lastName", "test");
		json.put("emailId", "test");
		json.put("departmentName", "test");
		json.put("roleName","test");
		
		System.out.println(json.toString());
	}

}
