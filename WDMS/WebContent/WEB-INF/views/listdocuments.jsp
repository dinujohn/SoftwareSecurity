<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Here are the list of documents for user: <core:out value="${loginForm.userName}" /></h3>
<ul>
  <li>Hello World</li>
</ul>
<ul>
  <li>Simple Form</li>
</ul>
 <ul>
  <li>Validation Form</li>
</ul>
<ul>
  <li>Login Form</li>
</ul>
<ul>
  <li>Registration Form</li>
</ul>
<ul>
	<li>File Upload</li>
</ul>
<ul>
	<li>Test</li>
</ul>

</body>
</html>