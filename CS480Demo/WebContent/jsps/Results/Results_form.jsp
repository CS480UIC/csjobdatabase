<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Results</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
  <h1>Add New Result</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletResults'/>" method="post">

	<input type="hidden" name="method" value="updateResults"/>
	Results Application ID   :<input type="text" name="application_id" value="<c:out value = '${form.application_id }' />"/>
	<br/>
	Results Id		:<input type="text" name="results_id" value="${form.results_id }"/>
	<br/>
	Results Application Link   ：<input type="text" name="application_link" value="${form.application_link }"/>
	<br/>
	Results Interview Progress   ：<input type="text" name="interview_progress" value="${form.interview_progress }"/>
	<br/>
	
	<input type="submit" value="Add"/>
</form>
  </body>
</html>
