<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Applications Table </h3>
	
	<a href="<c:url value='/jsps/Applications/Applications_form.jsp'/>" target="body">Company form</a>
	
	<table border="1" width="70%" align="center">
	<tr>
		<th>id</th>
		<th>location</th>
		<th>position</th>
		<th>jobdescription</th>
		<th>estimatedsalary</th>
		<th>company_id</th>
		<th>Action</th> 
	</tr>
<c:forEach items="${ApplicationsList}" var="application">
	<tr>
		<td>${application.getId() }</td>
		<td>${application.getLocation() } </td>
		<td>${application.getPosition() } </td>
		<td>${application.getJobDescription() }</td>
		<td>${application.getEstimatedSalary() }</td>
		<td>${application.getCompanyId() }</td>
		
		<td>
		<a href="<%=request.getContextPath()%>/showEditFormApplications?id=<c:out value='${application.getId()}'/>">Edit</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/deleteApplications?id=<c:out value='${application.getId()}'/>">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
