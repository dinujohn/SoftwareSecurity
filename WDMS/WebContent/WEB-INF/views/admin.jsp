<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>The following are the request: </h3>

<core:out value="${userRequest}"/>
<core:forEach items="${userRequest}" var="request">
<ul>

  <li>
  	<form:form method="post" commandName="singleRequest" action="admin.html">
  		<form:input type="text" path="reqContent" value="${request.reqContent}"/>
  		<form:input type="hidden" path="reqID" value="${request.reqID}" />
  		
  	  	<input type="submit" name="accept" value="Accept" />
  	  	<input type="submit" name="accept" value="Reject" />
  	 </form:form>
  </li>
</ul>
</core:forEach>

</body>
</html>