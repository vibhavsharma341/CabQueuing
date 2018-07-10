<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>

<head>
<style>
table, th, td {
    border: 5px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 10px;
}
</style>
</head>

<body>

<table style="width:100%" border="1px solid black">
  <tr>
    <th>RequestId</th>
    <th>CustomerId</th> 
    <th>Time Elapsed</th>
    <th>Status</th>
    <th>Driver</th>
  </tr>
  <c:forEach var="ride" items="${RequestList}">
            <tr>
                <td><c:out value="${ride.requestId}" /></td>
                <td><c:out value="${ride.customerId}" /></td>
                <td><c:out value="${ride.timeElapsed}" /></td>
                <td><c:out value="${ride.status}" /></td>
                <td><c:out value="${ride.driverId}" /></td>
            </tr>
        </c:forEach>
</table>


</body>
</html>
