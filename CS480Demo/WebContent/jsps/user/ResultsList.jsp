<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Computer Science Job DataBase</title>
</head>
<body>
    <center>
        <h1>Job Management</h1>
        <h2>
            <a href="Results.jsp?action=/new">Add New Job Results</a>
            &nbsp;&nbsp;&nbsp;
            <a href="Results.jsp?action=/list">List All Job Results</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Job Results</h2></caption>
            <tr>
                <th>ID</th>
                <th>InterviewCall</th>
            </tr>
            <c:forEach var="application" items="${listresult}">
                <tr>
                    <td><c:out value="${result.id}" /></td>
                    <td><c:out value="${result.interviewCall}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${result.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${result.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
