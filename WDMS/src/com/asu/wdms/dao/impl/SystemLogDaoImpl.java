package com.asu.wdms.dao.impl;
import com.asu.wdms.dao.SystemLogDao;
import com.asu.wdms.model.SystemLog;


public class SystemLogDaoImpl extends WdmsDaoImpl implements SystemLogDao {
	
	

	
	private final String user_select = "SELECT * FROM USER WHERE emailId= ?";
	private final String systemlog_insert = "INSERT INTO SYSTEMLOG( userID,sessionID,operation,startTime,endTime) VALUES(?,?,?,?,?)";
	private final String employee_update = "UPDATE EMPLOYEE SET EMP_NAME=?, EMP_DEPT=?,EMP_EMAILID=? WHERE EMP_ID = ?" ;


	@Override
	public void addLog(SystemLog systemLog) {
		this.getJdbcTemplate().update(this.systemlog_insert, new Object[]{systemLog.getUserId(),systemLog.getSessionId(),systemLog.getOperation(), systemLog.getStartTime(),systemLog.getEndTime()});
		
	}

	@Override
	public SystemLog getAllLog() {
		// TODO Auto-generated method stub
		return null;
	}

}
