<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pin change</title>
<style>
#pinchangehead{
font-size:50px;
position : absolute;
left : 500px;
color : yellow;
}
legend{
font-size:30px;
}
fieldset{
position : absolute;
top : 200px;
width:300px;	
left : 500px;
}
</style>
</head>
<body bgcolor = "blue">
<%!String user; %>

<% 

if(session.getAttribute("user") == null){
	response.sendRedirect("Login.html");
}else{
 user = session.getAttribute("user").toString();
}
%>
<h1 id = "pinchangehead">Welcome <%=' ' + user %></h1>
<fieldset>
<legend>Generate New Pin</legend>
<h1 id = "pinchangehead1">Enter The New Pin!!</h1>
<form action = "pinchangeserv" method = "post">
<input type = "text" name = "pininp" id = "pininpid">
<input type = "submit">
</form>
</fieldset>
</body>
</html>