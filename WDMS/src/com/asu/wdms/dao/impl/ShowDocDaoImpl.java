package com.asu.wdms.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.asu.wdms.dao.ShowDocDao;
import com.asu.wdms.model.Document;


public class ShowDocDaoImpl  implements ShowDocDao{
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

/*	public List<Document> getAllDocs() {
		
			
			List<Document> docs = jdbcTemplate.query(this.show_userdocs, 
				new BeanPropertyRowMapper(Document.class));
			System.out.println("Inside Shows");
			
		
		return docs;
	}
*/
	public List<Document> getAllDocs(Integer docID) {
		List<Document> docs = new ArrayList<Document>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(show_userdocs, new Object[]{docID, docID, docID});
		for (Map row : rows) {
			Document document = new Document();
			document.setDocID((Integer)(row.get("docID")));
			document.setDeptID((Integer)(row.get("deptID")));
			document.setDocName((String)(row.get("docName")));
			document.setCreatedBy((Integer)(row.get("createdBy")));
			document.setTitle((String)(row.get("title")));
			document.setCreationTime((String)(row.get("creationTime")));
			document.setLastModifiedTime((String)(row.get("lastModifiedTime")));
			document.setLastModifiedBy((Integer)(row.get("lastModifiedBy")));
			document.setCurrentVersion((Integer)(row.get("currentVersion")));
			document.setCheckedOut((Boolean)(row.get("checkedOut")));
			docs.add(document);
		}
		return docs;
	}
		
	private final String show_userdocs = 
			"select d.docName from document d where d.createdBy in " +
			"(select distinct(user_dept.userID) from (select u.userID, u.roleID, e.deptID " +  
			"from user u, employeedepartment e " +
			"where u.userID = e.empID) as user_dept, user u1 " +
			"where user_dept.deptID in (select deptID from employeedepartment where empID = ?) " + 
			"and user_dept.roleID <= u1.roleID " +
			"and u1.userID = ?) union " +
			"select d.docName from document d, usershareddoc u " +
			"where d.docID = u.docID and u.userID = ?";
	
}

