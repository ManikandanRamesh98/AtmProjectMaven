<%@page import="com.atm.impl.UserProfileImpl"%>
<%@page import="com.atm.models.UserProfileModel"%>

<%@page import="java.sql.ResultSet"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<style>
#userdetailfield {
	width: 500px;
}

label {
	color: yellow;
	font-size: 50px;
}

legend {
	font-size: 30px;
}
</style>
</head>
<body bgcolor="blue">
	<%!String user;
	
	UserProfileImpl userprofiledao = new UserProfileImpl();
	int id;
	String uname;
	Long accno;
	int bal;
	Long mobno;%>


	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		if (session.getAttribute("user") == null) {
			response.sendRedirect("Login.html");
		} else {
			user = session.getAttribute("user").toString();
		}
	%>

	<%
	UserProfileModel userprofilepojo = new UserProfileModel(user);
		ResultSet rs = userprofiledao.getuserdetails(userprofilepojo);
		while (rs.next()) {
			id = rs.getInt(1);
			uname = rs.getString(2);
			accno = rs.getLong(3);
			bal = rs.getInt(4);
			mobno = rs.getLong(5);
		}
	%>
	<fieldset id="userdetailfield">
		<legend>User Details</legend>

		<label>UserName : <%=" " + uname%></label><br> <br> <label>User
			Account No : <%=" " + accno%></label><br> <br> <label>Balance
			: <%=" " + bal%></label><br> <br> <label>Mobile No : <%=" " + mobno%></label><br>
		<br>
	</fieldset>
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