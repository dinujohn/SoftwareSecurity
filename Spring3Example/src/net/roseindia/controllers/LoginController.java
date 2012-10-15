package net.roseindia.controllers;


import java.util.Map;

import javax.validation.Valid;

import net.roseindia.form.LoginForm;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asu.ss.ApplicationContextProvider;
import com.asu.ss.UserDao;

@Controller
@RequestMapping("loginform.html")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		
		System.out.println("LoginController1");
		return "loginform";
	}
	
/*	@RequestMapping(method = RequestMethod.GET)
	public String showForm1(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		
		System.out.println("LoginController1");
		return "loginform";
	}*/

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map model) {
		
	//	result.getFieldValue(arg0)
		//String userName = "UserName";
		//String password = "password";
		if (result.hasErrors()) {
			
			System.out.println("Has errors"+ result.getErrorCount());
			for(ObjectError _err: result.getAllErrors()){
				System.out.println(_err.getDefaultMessage());
				System.out.println(_err.getObjectName());
			}
			return "loginform";
		}
		
		
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
		model.put("loginForm", loginForm);
		return "loginsuccess";
	}

}
