<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Read/Write Files</title>
<script language="JavaScript">
				function Validate()
				  {
					 var image =document.getElementById("image").value;
					 if(image!=''){
						  var checkimg = image.toLowerCase();
						  if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)){
							  alert("Please enter  Image  File Extensions .jpg,.png,.jpeg");
							  document.getElementById("image").focus();
							  return false;
						    }
						 }
					 return true;
				 }			
</script>
</head>
<body>
	<core:forEach var="doc" items="${document}">
	<br> <core:out value = "${doc.docName}"/>
	</core:forEach>
	<form:form modelAttribute="uploadItem" name="frm" method="post"
	enctype="multipart/form-data" onSubmit="return Validate();">
	<fieldset><legend>Upload File</legend>
	<table>
		<tr>
			<td><form:label for="fileData" path="fileData">File</form:label><br />
			</td>
			<td><form:input path="fileData" id="image" type="file" /></td>
		</tr>
		<tr>
			<td><br />
			</td>
			<td><input type="submit" value="Upload" /></td>
		</tr>
	</table>
	</fieldset>
</form:form>
	
</body>
</html>