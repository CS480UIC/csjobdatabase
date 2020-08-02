<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Edit Results</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
  <h1>Edit Results</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='updateResults'/>" method="post">

	<input type="hidden" name="method" value="updateResults"/>
	Results Application ID   :<input type="text" name="application_id" value="<c:out value = '${ResultsInfo.application_id }' />"/>
	<br/>
	Results ID		:<input type="text" name="results_id" value="${ResultsInfo.results_id }"/>
	<br/>
	Results Application Link   ：<input type="text" name="application_link" value="${ResultsInfo.application_link }"/>
	<br/>
	Results Interview Progress   ：<input type="text" name="interview_progress" value="${ResultsInfo.interview_progress }"/>
	<br/>
	
	<input type="submit" value="Edit"/>
</form>
  </body>
</html>
