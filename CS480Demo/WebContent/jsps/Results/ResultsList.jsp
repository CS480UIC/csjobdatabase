<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Results Table </h3>
	
	<a href="<c:url value='/jsps/Results/Results_form.jsp'/>" target="body">Result form</a>
	
	<table border="1" width="70%" align="center">
	<tr>
		<th>results_id</th>
		<th>application_id</th>
		<th>application_link</th>
		<th>interview_progress</th>
		<th>Action</th> 
	</tr>
<c:forEach items="${ResultsList}" var="result">
	<tr>
		<td>${result.getResultsId() }</td>
		<td>${result.getApplicationId() } </td>
		<td>${result.getApplicationLink() } </td>
		<td>${result.getInterviewProgress() }</td>
		
		<td>
		<a href="<%=request.getContextPath()%>/showEditFormResults?Results_id=<c:out value='${result.getResultsId()}'/>">Edit</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/deleteResults?Results_id=<c:out value='${result.getResultsId()}'/>">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
