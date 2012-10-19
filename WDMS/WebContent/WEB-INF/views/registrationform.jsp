<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="Post" action="registrationform.html"
	commandName="registration">
	<table>
		<tr>
			<td>First Name:<FONT color="red"><form:errors
				path="firstName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="firstName" /></td>
		</tr>
		<tr>
			<td>Last Name:<FONT color="red"><form:errors
				path="lastName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="lastName" /></td>
		</tr>
		<tr>
			<td>Department Name:<FONT color="red"><form:errors
				path="departmentName" /></FONT></td>
		</tr>
		<tr>
			<td><form:select path="departmentName">
				<form:option value="" label="Select"/>
				<form:option value="1" label="IT"/>
				<form:option value="2" label="R&D"/>
				<form:option value="3" label="Sales"/>
			</form:select></td>
		</tr>
		<tr>
			<td>Role Name:<FONT color="red"><form:errors
				path="roleName" /></FONT></td>
		</tr>
		<tr>
				<td><form:select path="roleName">
					<form:option value="" label="Select"/>
					<form:option value="1" label="CEO"/>
					<form:option value="2" label="PRESIDENT"/>
					<form:option value="3" label="MANAGER"/>
					<form:option value="4" label="EMPLOYEE"/>
				</form:select></td>
		</tr>
		<tr>
			<td>Password:<FONT color="red"><form:errors
				path="password" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="password" /></td>
		</tr>

		<tr>
			<td>Confirm Password:<FONT color="red"><form:errors
				path="confirmPassword" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="confirmPassword" /></td>
		</tr>

		<tr>
			<td>Email:<FONT color="red"><form:errors path="emailId" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="emailId" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>