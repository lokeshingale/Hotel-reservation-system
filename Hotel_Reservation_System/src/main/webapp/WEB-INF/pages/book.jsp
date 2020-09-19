<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<h1 style="text-align:center; color:orange">Booking User Room</h1>
<form:form modelAttribute="book">
	<table align="center">
		<tr>
			<td><label> Name: </label></td>
			<td><form:input path="name"/></td>
		</tr>

		<tr>
			<td><label> No of Guest: </label></td>
			<td><form:input path="no_of_guest" /></td>
		</tr>

		<tr>
			<td><label> Room Type:</label></td>
			<td><form:select path="room_type">
					<form:option value="Standard">Standard</form:option>
					<form:option value="Deluxe">Deluxe</form:option>
					<form:option value="Luxury">Luxury</form:option>
				</form:select></td>
		</tr>
		<tr>
			<td><label> Check in Date: </label></td>
			<td><input type="date" name="checkInDate" /></td>
		</tr>
		<tr>
			<td><label>Check out Date:</label></td>
			<td><input type="date" name="checkOutDate" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Book Now"></td>
		</tr>

	</table>
</form:form>
<br>
<c:if test="${!empty conform }">
	<h4 style="color: blue; text-align: center">${conform}</h4>
</c:if>
</body>
</html>