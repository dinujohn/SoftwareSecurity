package com.asu.wdms.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asu.wdms.form.Registration;



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
		model.put("Registration", registration);
		return "registrationform";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid Registration registration,
			BindingResult result, Map model) {
		System.out.println("processRegistration");
		// set custom Validation by user
	//	registrationValidation.validate(registration, result);
		model.put("Registration", registration);
		if (result.hasErrors()) {
			
			return "registrationform";
		}
		return "registrationsuccess";
	}
}
