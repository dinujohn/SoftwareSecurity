package com.asu.wdms.controllers;


import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asu.wdms.common.ApplicationContextProvider;
import com.asu.wdms.dao.SystemLogDao;
import com.asu.wdms.dao.UserDao;
import com.asu.wdms.form.LoginForm;
import com.asu.wdms.form.Registration;
import com.asu.wdms.model.SystemLog;
import com.asu.wdms.model.User;



@Controller
@RequestMapping("loginform.html")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		Registration registration = new Registration();
		model.put("loginForm", loginForm);
		model.put("registration",registration);
		
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();//WebApplicationContextUtils.genew ClassPathXmlApplicationContext("dispatcher-jdbc.xml");
		SystemLogDao sysLogDao = (SystemLogDao)ctx.getBean("SystemLogDao");
		
		SystemLog log = new SystemLog();
		log.setUserId(null);
		log.setOperation("Show Login Page");
		log.setStartTime(new Date(System.currentTimeMillis()));
		log.setEndTime(new Date(System.currentTimeMillis()));
		sysLogDao.addLog(log);
		
		System.out.println("LoginController1");
		return "loginform";
	}
	


	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map model) {
		
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();//WebApplicationContextUtils.genew ClassPathXmlApplicationContext("dispatcher-jdbc.xml");
		SystemLogDao sysLogDao = (SystemLogDao)ctx.getBean("SystemLogDao");
		
		SystemLog log = new SystemLog();
		log.setUserName(loginForm.getUserName());
		log.setOperation("Login Sign-In");
		log.setStartTime(new Date(System.currentTimeMillis()));
		log.setEndTime(new Date(System.currentTimeMillis()));
		sysLogDao.addLog(log);
		
	//	result.getFieldValue(arg0)
		//String userName = "UserName";
		//String password = "password";
		if (result.hasErrors()) {
			
			System.out.println("Has errors"+ result.getErrorCount());
			for(ObjectError _err: result.getAllErrors()){
				System.out.println(_err.getDefaultMessage());
				System.out.println(_err.getObjectName());
				
			}
			
		}
		
		
		
		ctx = ApplicationContextProvider.getApplicationContext();//WebApplicationContextUtils.genew ClassPathXmlApplicationContext("dispatcher-jdbc.xml");
		UserDao userDao = (UserDao)ctx.getBean("userDao");
		
		System.out.println("UserName: "+loginForm.getUserName());
		User user = userDao.getUser(loginForm.getUserName());
		if(user==null){
			//result.
			return "loginform";
		}
		String password = user.getPassword();
		
		System.out.println(">>>> Password: "+password);
		
		loginForm = (LoginForm) model.get("loginForm");
		//if (!loginForm.getUserName().equals(userName)
				if(!loginForm.getPassword().equals(password)) {
			return "loginfail";
		}
		model.put("loginForm", loginForm);
		return "listdocuments";
	}

}
