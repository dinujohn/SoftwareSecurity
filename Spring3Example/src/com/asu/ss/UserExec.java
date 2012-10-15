package com.asu.ss;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class UserExec {
	
	
	public static void main(String[] args) {
	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc.xml");
		UserDao userDao = (UserDao)ctx.getBean("userDao");
	/*	User user = new User();
		user.setEmailId("djohn7@asu.edu");
		user.setFirstName("Dinu");
		user.setLastName("John");
		
		userDao.saveUser(user);*/
		
		//getting the data 
		User user1 =userDao.getUser("djohn7@asu.edu");
		
		System.out.println("Employee name :"+user1.getFirstName());
		System.out.println("Employee email :"+user1.getEmailId());
		//System.out.println("Employee department:"+emp.getEmployeeDept());
		
		
	}

}
