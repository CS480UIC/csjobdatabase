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
        <c:if test="${result != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${result == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${result != null}">
                        Edit results
                    </c:if>
                    <c:if test="${result == null}">
                        Add New results
                    </c:if>
                </h2>
            </caption>
                <c:if test="${result != null}">
                    <input type="hidden" name="id" value="<c:out value='${result.id}' />" />
                </c:if>           
            <tr>
                <th>InterviewCall: </th>
                <td>
                    <input type="text" name="interviewCall" size="45"
                            value="<c:out value='${result.interviewCall}' />"
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
