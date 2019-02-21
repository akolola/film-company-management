<%@page import="com.myproject.service.ActorService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updated</title>
</head>
	<body>
		<%
		
		ActorService accServ = new ActorService();
		if (request.getParameter("name")!=null){
		accServ.updName(request.getParameter("name"), Long.valueOf(request.getParameter("id")));
		}
		
		
		if (request.getParameter("email")!=null)
		accServ.updEmail(request.getParameter("email"), Long.valueOf(request.getParameter("id")));
		%>
		<h2>Updated</h2>
		<form action="/ActorList.jsp"><input type="submit" value="Back"></form>
	</body>
</html>