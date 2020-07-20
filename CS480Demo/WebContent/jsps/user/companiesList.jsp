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
            <a href="companies.jsp?action=/new">Add New Job Listing</a>
            &nbsp;&nbsp;&nbsp;
            <a href="companies.jsp?action=/list">List All Job Listings</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Jobs</h2></caption>
            <tr>
                <th>ID</th>
                <th>Company Name</th>
                <th>Category</th>
                <th>JobType</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="company" items="${listcompany}">
                <tr>
                    <td><c:out value="${company.id}" /></td>
                    <td><c:out value="${cmopany.name}" /></td>
                    <td><c:out value="${company.category}" /></td>
                    <td><c:out value="${company.jobtype}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${company.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${company.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
