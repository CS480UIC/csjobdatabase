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
            <a href="/UserServletApplications/new">Add New Job Listing</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/UserServletApplications/list">List All Job Listings</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${application != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${application == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${application != null}">
                        Edit applications
                    </c:if>
                    <c:if test="${application == null}">
                        Add New applications
                    </c:if>
                </h2>
            </caption>
                <c:if test="${applications != null}">
                    <input type="hidden" name="id" value="<c:out value='${application.id}' />" />
                </c:if>           
            <tr>
                <th>Location: </th>
                <td>
                    <input type="text" name="location" size="45"
                            value="<c:out value='${application.location}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Position: </th>
                <td>
                    <input type="text" name="position" size="45"
                            value="<c:out value='${application.position}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>JobDescription: </th>
                <td>
                    <input type="text" name="jobDescription" size="45"
                            value="<c:out value='${application.jobdescription}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>EstimatedSalary: </th>
                <td>
                    <input type="text" name="estimatedSalary" size="45"
                            value="<c:out value='${application.esitmatedSalary}' />"
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
