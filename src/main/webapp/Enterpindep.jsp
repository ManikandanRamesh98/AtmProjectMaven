<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h1 {
	position: absolute;
	color: yellow;
	font-size: 90px;
	left: 480px;
}

form {
	position: absolute;
	top: 300px;
	left: 500px;
}

input {
	height: 90px;
	width: 300px;
	background-color: blue;
	font-size: 60px;
	border-color: blue;
}
#timehead{
position : relative;
left : 0px;
color : black;
font-size:40px;
}
</style>
</head>
<body bgcolor="blue">
	<%
	int amount = Integer.parseInt(request.getParameter("inpdep"));
	session.setAttribute("depamount", amount);
	%>
	<h1>Enter Pin</h1>
	<form action="Enterpindepservlet">
		<input type="password" name="deppin" id="withpinid" required autofocus>

	</form>
<h1 id = "timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 30;
let i;
window.addEventListener('load', () =>{
	
	 i= setInterval(() => {
		if(time > 0){
			if(time >= 10){
				
		th.innerHTML = "00 : " + time--;
		
			}else{
				th.style.color = "red";
				th.innerHTML = "00 : 0" + time--;
			}
		}else{
			clearInterval(i);
			window.location.assign("Login.html");
		}
	},1000);
	
});



</script>
</html>