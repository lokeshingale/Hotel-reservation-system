<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<a class="a1" href="viewReport.htm">View Report</a>
</div>

<h1 style="color: red; text-align: center">Room Add</h1>

<form:form modelAttribute="available">
	<table align="center">
		<tr>
			<td><label> Room Type</label></td>
			<td><form:select path="room_type">
					<form:option value="Standard">Standard</form:option>
					<form:option value="Deluxe">Deluxe</form:option>
					<form:option value="Luxury">Luxury</form:option>
				</form:select></td>
		</tr>
		<tr>
			<td><label> Capacity </label></td>
			<td><form:input path="capacity" /></td>
		</tr>
		<tr>
			<td><label>Date </label></td>
			<td><form:input type="date" path="date" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Add"></td>
		</tr>

	</table>
</form:form>
<br>
<c:if test="${!empty result }">
	<h4 style="color: blue; text-align: center">${result}</h4>
</c:if>
</body>
</html>






