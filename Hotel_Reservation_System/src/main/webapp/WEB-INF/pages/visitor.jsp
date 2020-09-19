<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

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


 <h1  style="color:red;text-align:center"> Welcome to Registration </h1>
   
   <form:form modelAttribute="register">
   <table align="center">
       <tr>
           <td><label> Name</label> </td>
           <td> <form:input path="name"/> </td>      
       </tr>
       <tr>
           <td><label> Email </label></td>
           <td> <form:input path="email"/> </td>      
       </tr>
        <tr>
           <td><label> Mobile Number </label></td>
           <td> <form:input path="mobileNumber"/> </td>      
       </tr>
        <tr>
           <td><label> Password</label> </td>
           <td> <form:input path="pwd"/> </td>      
       </tr>
       <tr>
         <td></td><td> <input type="submit" value="Register"> </td>  
       </tr>
   
   </table>   
   </form:form>
     <br>
     <c:if test="${!empty output }">
        <h4 style="color:blue;text-align:center"> ${output}  </h4>
     </c:if>
     </body>
     </html>