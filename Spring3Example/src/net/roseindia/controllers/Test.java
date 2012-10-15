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
@RequestMapping("test.html")
public class Test {

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		//LoginForm loginForm = new LoginForm();
		//model.put("loginForm", loginForm);
		
		System.out.println("test");
		return "test";
	}
	


}
