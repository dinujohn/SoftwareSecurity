package com.asu.wdms.controllers;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.asu.wdms.common.ApplicationContextProvider;
import com.asu.wdms.dao.ShowDocDao;
import com.asu.wdms.form.UploadItem;
import com.asu.wdms.model.Document;

@Controller
@RequestMapping("listdocuments.html")
public class ListDocumentsController {
	private String uploadFolderPath;
	ServletConfig config;

	public String getUploadFolderPath() {
		return uploadFolderPath;
	}

	public void setUploadFolderPath(String uploadFolderPath) {
		this.uploadFolderPath = uploadFolderPath;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String showForm(Model model1, Map model) {
		//viewFiles file = new viewFiles();
		//model.put("file", file);
		
		
		ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();//WebApplicationContextUtils.genew ClassPathXmlApplicationContext("dispatcher-jdbc.xml");
		ShowDocDao showDao = (ShowDocDao)ctx.getBean("ShowDocDao");
		List<Document> docs = showDao.getAllDocs(1);
		model.put("document", docs);
		model1.addAttribute(new UploadItem());
		for(Document doc: docs)
		{
						
			System.out.println(doc.getDocName());
		}
		
		System.out.println("Comes here");
		return "listdocuments";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(UploadItem uploadItem, BindingResult result,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		
		if (result.hasErrors()) {
			
			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error: " + error.getCode() + " - "
						+ error.getDefaultMessage());
			}
			return "listdocuments";
		}

		// Some type of file processing...
		System.err.println("-------------------------------------------");
		try {
			MultipartFile file = uploadItem.getFileData();
			String fileName = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			System.out.println("i am here: "+file);
			if (file.getSize() > 0) {
				
				inputStream = file.getInputStream();
				if (file.getSize() > 100000) {
					System.out.println("File Size:::" + file.getSize());
					return "listdocuments";
				}
				System.out.println("size::" + file.getSize());
				fileName = request.getRealPath("") + "/images/"
						+ file.getOriginalFilename();
				outputStream = new FileOutputStream(fileName);
				System.out.println("fileName:" + file.getOriginalFilename());

				int readBytes = 0;
				byte[] buffer = new byte[10000];
				while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
				System.out.println("file upload successfully at :  "+ fileName.toString());
			}

			// ..........................................
			session.setAttribute("uploadFile", file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "uploadsuccess";
	}
}
