package com.asu.wdms.dao;

import com.asu.wdms.model.SystemLog;

public interface SystemLogDao {
	public void addLog(SystemLog systemLog);
	public SystemLog getAllLog();
	
}
