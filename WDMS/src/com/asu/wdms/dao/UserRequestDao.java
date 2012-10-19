package com.asu.wdms.dao;

import java.util.List;

import com.asu.wdms.model.UserRequest;

public interface UserRequestDao {
	
	public void saveRequest(UserRequest request);
	public List<UserRequest> getAllRequest();
	public void updateRequestStatus(int reqId, int status);

}
