package com.asu.wdms.model;


public class Document {

	public Integer docID;
	public Integer deptID;
	public String docName;
	public String docType;
	public Integer createdBy;
	public String title;
	public String creationTime;
	public String lastModifiedTime;
	public Integer lastModifiedBy;
	public Integer currentVersion;
	public Boolean checkedOut;
	public Integer getDocID() {
		return docID;
	}
	public void setDocID(Integer docID) {
		this.docID = docID;
	}
	public Integer getDeptID() {
		return deptID;
	}
	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public String getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(Integer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Integer getCurrentVersion() {
		return currentVersion;
	}
	public void setCurrentVersion(Integer currentVersion) {
		this.currentVersion = currentVersion;
	}
	public Boolean getCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(Boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	
	
		
	
}
