<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Companies Table </h3>
	
	<a href="<c:url value='/jsps/companies/companies_form.jsp'/>" target="body">Company form</a>
	
	<table border="1" width="70%" align="center">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>category</th>
		<th>jobtype</th>
		<th>Action</th> 
	</tr>
<c:forEach items="${companiesList}" var="company">
	<tr>
		<td>${company.getId() }</td>
		<td>${company.getName() } </td>
		<td>${company.getCategory() } </td>
		<td>${company.getJobtype() }</td>
		
		<td>
		<a href="<%=request.getContextPath()%>/showEditForm?company_id=<c:out value='${company.getId()}'/>">Edit</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/deletecompanies?company_id=<c:out value='${company.getId()}'/>">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
