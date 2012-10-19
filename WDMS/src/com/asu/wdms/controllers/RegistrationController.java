package com.asu.wdms.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asu.wdms.common.ApplicationContextProvider;
import com.asu.wdms.dao.UserRequestDao;
import com.asu.wdms.form.Registration;
import com.asu.wdms.model.UserRequest;



@Controller
@RequestMapping("/registrationform.html")
public class RegistrationController {
	/*@Autowired
	private RegistrationValidation registrationValidation;

	public void setRegistrationValidation(
			RegistrationValidation registrationValidation) {
		this.registrationValidation = registrationValidation;
	}
*/
	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model) {
		System.out.println("showRegistration");
		Registration registration = new Registration();
		model.put("registration", registration);
		return "registrationform";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid Registration registration,
			BindingResult result, Map model) {
		System.out.println("processRegistration");
		// set custom Validation by user
	//	registrationValidation.validate(registration, result);
		model.put("registration", registration);
		if (result.hasErrors()) {
			
			return "registrationform";
		}
		
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
		UserRequestDao userRequestDao = (UserRequestDao)ctx.getBean("UserRequestDao");
		
		UserRequest usrRequest = new UserRequest();
		
		/*
		 * 0- Add User
		 * 1- Delete User
		 * 2- Update User
		 */
		usrRequest.setReqType(0);
		usrRequest.setStatus(0);
		usrRequest.setComment("Add User");
		
		JSONObject json = new JSONObject();
		json.put("firstName", registration.getFirstName());
		json.put("lastName", registration.getLastName());
		json.put("emailId", registration.getEmailId());
		json.put("departmentName", registration.getDepartmentName());
		json.put("roleName", registration.getRoleName());
		json.put("password", registration.getPassword());
		
		usrRequest.setReqContent(json.toString());
		
		
		userRequestDao.saveRequest(usrRequest);
		
		return "registrationsuccess";
	}
	
	@ResponseBody Registration getJson(Registration registration){
		return registration;
	}
}
