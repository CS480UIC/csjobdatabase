<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Application</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
  <h1>Add New Application</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletApplications'/>" method="post">

	<input type="hidden" name="method" value="updateApplications"/>
	Application Location   :<input type="text" name="location" value="<c:out value = '${form.location }' />"/>
	<br/>
	Application Id		:<input type="text" name="id" value="${form.id }"/>
	<br/>
	Application Position   ：<input type="text" name="position" value="${form.position }"/>
	<br/>
	Application JobDescription   ：<input type="text" name="jobDescription" value="${form.jobDescription }"/>
	<br/>
	Application estimatedSalary   ：<input type="text" name="estimatedSalary" value="${form.estimatedSalary }"/>
	<br/>
	Application Company ID   ：<input type="text" name="company_id" value="${form.company_id }"/>
	<br/>
	
	<input type="submit" value="Add"/>
</form>
  </body>
</html>
