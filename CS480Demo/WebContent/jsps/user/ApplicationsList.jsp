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
            <a href="/UserServletApplications/new">Add New Job Application</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/UserServletApplications/list">List All Job Application</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Applications</h2></caption>
            <tr>
                <th>ID</th>
                <th>Location</th>
                <th>Position</th>
                <th>JobDescription</th>
                <th>EstimatedSalary</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="application" items="${listApplications}">
                <tr>
                    <td><c:out value="${application.id}" /></td>
                    <td><c:out value="${application.location}" /></td>
                    <td><c:out value="${application.position}" /></td>
                    <td><c:out value="${application.jobdescription}" /></td>
                    <td><c:out value="${application.estimatedSalary}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${application.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${application.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
