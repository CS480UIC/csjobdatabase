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
        <c:if test="${company != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${company == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${company != null}">
                        Edit companies
                    </c:if>
                    <c:if test="${company == null}">
                        Add New companies
                    </c:if>
                </h2>
            </caption>
                <c:if test="${company != null}">
                    <input type="hidden" name="id" value="<c:out value='${company.id}' />" />
                </c:if>           
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${company.title}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Category: </th>
                <td>
                    <input type="text" name="category" size="45"
                            value="<c:out value='${company.category}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>JobType: </th>
                <td>
                    <input type="text" name="jobtype" size="45"
                            value="<c:out value='${company.jobtype}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>
