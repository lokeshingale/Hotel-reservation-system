<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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



 <h1  style="color:red;text-align:center"> Admin Login Page </h1>
   
   <form:form modelAttribute="login_admin">
   <table align="center">
       
       <tr>
           <td><label> Email </label></td>
           <td> <form:input path="email"/> </td>      
       </tr>
        <tr>
           <td><label> Password </label></td>
           <td> <form:input path="pwd"/> </td>      
       </tr>
       <tr>
         <td></td><td> <input type="submit" value="Login"> </td>  
       </tr>
   
   </table>   
   </form:form>
   
   </body>
   </html>