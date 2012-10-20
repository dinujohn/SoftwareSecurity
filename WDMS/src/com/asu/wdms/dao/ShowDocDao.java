package com.asu.wdms.dao;

import java.util.List;

import com.asu.wdms.model.Document;

public interface ShowDocDao {
	public List<Document> getAllDocs(Integer docID);
	//public void insertDocument(Document)
}

