<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Welcome to SPRING MVC Session </h1>

<form action="save" method="post" modelAttribute="UserProfile">
Name <input type=text name=username><br>
Password <input type=password name=password><bR>
Address <input type=text name=addr> <br>
<input type=submit value="Login">
</form>


<table border=2>
<tr>
 <td> Name </td>
 <td> Address </td>
<tr>
<c:forEach items="${records}" var="user">
<tr>
<td> ${user.username} </td>
<td> ${user.addr} </td>
<td> <a href="deluser?username=${user.username}">Delete</a> </td>
<td> <a href="modifyuser?username=${user.username}">Modify</a> </td>
<tr>
</c:forEach>


</table>

<form action=updateprofile method=post>
 <input type=text name=username value="${userdetail.username}"><br>
 <input type=text name=password value="${userdetail.password}"><br>
 <input type=text name=addr><br>
 
 <input type=submit>


</form>



</body>
</html>