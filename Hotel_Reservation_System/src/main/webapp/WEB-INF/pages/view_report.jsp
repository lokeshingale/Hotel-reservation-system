<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <!DOCTYPE html>
<html>
<head>
<title>Hotel Reservation System</title>
<style>
.a1{
text-decoration:none;
color:orange;
float:right;
padding: 14px 16px;
text-align:center;
font-size: 18px;
}
</style>
</head>
<body>
<h1 style="text-align:left; color:orange">Hotel Reservation System</h1>
<div style="background-color:green; height:50px; width:100%">
</div>
    
    
<c:choose>
<c:when test="${! empty listdto}">
<h1 style="color: Orange; text-align: center">Report</h1>
<table align="center">
      <tr bgcolor="#9999ff" height="40px" width="600">
       <th>Book Id</th> <th>User Name </th> <th>No Of Guest </th> <th>Room Type</th> <th>Check In Date </th> <th>Check Out Date </th>
      </tr>
      <c:forEach var="view" items="${listdto }">
        <tr height="30px" width="600" align="center">
           <td>${view.bid}</td>
          <td>${view.name}</td>
           <td>${view.no_of_guest}</td>
           <td>${view.room_type}</td>
           <td>${view.checkInDate}</td>
           <td>${view.checkOutDate}</td>
        </tr>
      </c:forEach>
    
    </table>
    </c:when>
    
    <c:otherwise>
    </c:otherwise>
 </c:choose>
 </body>
 </html>