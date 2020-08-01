<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Edit Application</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
  <h1>Edit Application</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='updateApplications'/>" method="post">

	<input type="hidden" name="method" value="updateApplications"/>
	Application Location   :<input type="text" name="location" value="<c:out value = '${applicationInfo.location }' />"/>
	<br/>
	Application ID		:<input type="text" name="id" value="${applicationInfo.id }"/>
	<br/>
	Application Position   ：<input type="text" name="position" value="${applicationInfo.position }"/>
	<br/>
	Application JobDescription   ：<input type="text" name="jobDescription" value="${applicationInfo.jobDescription }"/>
	<br/>
	Application EstimatedSalary   ：<input type="text" name="estimatedSalary" value="${applicationInfo.estimatedSalary }"/>
	<br/>
	Application Company ID   ：<input type="text" name="company_id" value="${applicationInfo.company_id }"/>
	<br/>
	
	<input type="submit" value="Edit"/>
</form>
  </body>
</html>
