<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Company</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
  <h1>Add New Company</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletcompanies'/>" method="post">

	<input type="hidden" name="method" value="updateCompany"/>
	Company Name   :<input type="text" name="company_name" value="<c:out value = '${form.company_name }' />"/>
	<br/>
	Company ID		:<input type="text" name="company_id" value="${form.company_id }"/>
	<br/>
	Company Category   ：<input type="text" name="company_category" value="${form.company_category }"/>
	<br/>
	Company JobType   ：<input type="text" name="company_jobtype" value="${form.company_jobtype }"/>
	<br/>
	
	<input type="submit" value="Add"/>
</form>
  </body>
</html>
