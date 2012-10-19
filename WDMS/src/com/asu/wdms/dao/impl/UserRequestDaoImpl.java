package com.asu.wdms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.Bean1;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.asu.wdms.dao.UserRequestDao;
import com.asu.wdms.model.User;
import com.asu.wdms.model.UserRequest;

public class UserRequestDaoImpl extends WdmsDaoImpl implements UserRequestDao{
	
		
	private final String request_select = "SELECT * FROM REQUEST WHERE STATUS=0";
	private final String request_insert = "INSERT INTO REQUEST( reqType,reqContent,status,comment) VALUES(?,?,?,?)";
	private final String request_update = "UPDATE REQUEST SET STATUS=? WHERE reqID = ?" ;

	
	@Override
	public void saveRequest(UserRequest request) {
		this.getJdbcTemplate().update(this.request_insert, new Object[]{request.getReqType(),request.getReqContent(),request.getStatus(), request.getComment()});
		
	}

	@Override
	public List<UserRequest> getAllRequest() {
		
		List<UserRequest> request = (List<UserRequest>) getJdbcTemplate()
				.query(this.request_select, new BeanPropertyRowMapper(UserRequest.class));

		return request;
	}

	@Override
	public void updateRequestStatus(int reqId, int status) {
		this.getJdbcTemplate().update(this.request_update, new Object[]{new Integer(status), new Integer(reqId)});
		
	}

}
