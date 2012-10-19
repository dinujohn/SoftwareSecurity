package com.asu.wdms.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;



import net.sf.json.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asu.wdms.common.ApplicationContextProvider;
import com.asu.wdms.dao.UserDao;
import com.asu.wdms.dao.UserRequestDao;
import com.asu.wdms.form.AdminPage;
import com.asu.wdms.form.LoginForm;
import com.asu.wdms.form.Registration;
import com.asu.wdms.model.User;
import com.asu.wdms.model.UserRequest;



@Controller
@RequestMapping("admin.html")
public class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	public String showRequest(Map model) {
		
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
		UserRequestDao userRequestDao = (UserRequestDao)ctx.getBean("UserRequestDao");
		
		List<UserRequest> request = userRequestDao.getAllRequest();
				
		for(UserRequest req: request){
			System.out.println(req.getReqContent());
			
		}
		
		//AdminPage adminPage = new AdminPage();
		
		UserRequest singleRequest =  new UserRequest();
		
		System.out.println("Request Size: "+request.size());
		
		model.put("userRequest", request);
		//model.put("adminPage", adminPage);
		model.put("singleRequest", singleRequest);
						
		
		return "admin";
	}
	


	@RequestMapping(method = RequestMethod.POST, params="accept=Accept")
	public String processForm(UserRequest singleRequest, Map model) {
			
	/*	
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();//WebApplicationContextUtils.genew ClassPathXmlApplicationContext("dispatcher-jdbc.xml");
		UserDao userDao = (UserDao)ctx.getBean("userDao");
		
		System.out.println("UserName: "+loginForm.getUserName());
		String password = userDao.getUser(loginForm.getUserName()).getPassword();
		
		System.out.println(">>>> Password: "+password);
		
		loginForm = (LoginForm) model.get("loginForm");
		//if (!loginForm.getUserName().equals(userName)
				if(!loginForm.getPassword().equals(password)) {
			return "loginfail";
		}
		model.put("loginForm", loginForm);*/
		
		System.out.println(singleRequest.getReqContent());
		
		JSONObject json = JSONObject.fromObject(singleRequest.getReqContent());
		
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
		UserRequestDao userRequestDao = (UserRequestDao)ctx.getBean("UserRequestDao");
		
		userRequestDao.updateRequestStatus(singleRequest.getReqID(), 1);
		
		UserDao userDao = (UserDao)ctx.getBean("userDao");
		
			
		User user = new User();
		user.setFirstName(json.get("firstName").toString());
		user.setLastName(json.get("lastName").toString());
		user.setEmailId(json.get("emailId").toString());
		user.setDeptId(111); //departmentName
		user.setRoleId(2);//
		user.setPassword(json.get("password").toString());
		user.setValidUser(1);
		
		userDao.saveUser(user);
		
		List<UserRequest> request = userRequestDao.getAllRequest();
	//	System.out.println(request.size());
		//System.out.println(model.get("adminPage"));
		
	
		
		//adminPage = new AdminPage();
		
		singleRequest =  new UserRequest();
		
		System.out.println("Request Size: "+request.size());
		
		model.put("userRequest", request);
	//	model.put("adminPage", adminPage);
		model.put("singleRequest", singleRequest);
		return "admin";
	}
	
	@RequestMapping(method = RequestMethod.POST, params="accept=Reject")
	public String processAnotherRequest(UserRequest singleRequest, Map model) {
		System.out.println(singleRequest.getReqContent());
		
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
		UserRequestDao userRequestDao = (UserRequestDao)ctx.getBean("UserRequestDao");
		
		userRequestDao.updateRequestStatus(singleRequest.getReqID(), 1);
		
		List<UserRequest> request = userRequestDao.getAllRequest();
	//	System.out.println(request.size());
		//System.out.println(model.get("adminPage"));
		
	
		
		//adminPage = new AdminPage();
		
		singleRequest =  new UserRequest();
		
		System.out.println("Request Size: "+request.size());
		
		model.put("userRequest", request);
	//	model.put("adminPage", adminPage);
		model.put("singleRequest", singleRequest);
		return "admin";
	}

}
