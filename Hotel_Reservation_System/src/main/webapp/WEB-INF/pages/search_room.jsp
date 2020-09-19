<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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


<h1 style="color: red; text-align: center">Search Room</h1>
<form:form modelAttribute="search">
	<table align="center">

		<tr>
			<td><label> Check In date: </label></td>
			<td><input type="date" name="checkInDate"/></td>
		</tr>
		<tr>
			<td><label> Check Out Date: </label></td>
			<td><input type="date" name="checkOutDate" /></td>
		</tr>
		<tr>
			<td></td><td><input type="submit" value="Search Room" /></td>
		</tr>
	</table>
</form:form>
<br><br>


<c:choose>
<c:when test="${! empty listdto}">
<h1 style="color: Orange; text-align: center">Search Based On Date Wise Room Available</h1>
<table align="center"  width="600">
      <tr bgcolor="#9999ff" height="40px" width="120px">
       <th>Room Id</th> <th>Room Type </th> <th>Capacity </th> <th>Date </th> <th>Booking </th> 
      </tr>
      <c:forEach var="room" items="${listdto }">
        <tr height="30px" width="120px" align="center">
           <td>${room.aid}</td>
          <td>${room.room_type}</td>
           <td>${room.capacity}</td>
           <td>${room.date}</td>
           <td><!-- <button style="width:100"> --><a href="booking.htm">Book</a><!-- </button> --></td>
        </tr>
      </c:forEach>
    
    </table>
    </c:when>
    
    <c:otherwise>
    </c:otherwise>
 </c:choose>
 
 </body>
 </html>