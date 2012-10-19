package com.asu.wdms.form;

import com.asu.wdms.model.UserRequest;

public class AdminPage {
	
	private String request;
	
	private UserRequest userRequest;
	
	public UserRequest getUserRequest() {
		return userRequest;
	}
	public void setUserRequest(UserRequest userRequest) {
		this.userRequest = userRequest;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getRequest() {
		return request;
	}
}
