<%@page import="com.myproject.service.FilmService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete</title>
</head>
	<body>
		<%FilmService accServ = new FilmService();
		Long id;
		int condition = 1;
		
		try {
			id = Long.valueOf(request.getParameter("id"));
		}
		catch(NumberFormatException e) {
			condition = 0;
		}
		
		
		if(condition == 0) {
			%>
			Inputed data has no numbers
			<%			
			}
			else {
		
		accServ.deleteFilm(Long.valueOf(request.getParameter("id"))); %>
		<h2>Film deleted</h2><% 
			}%>
	
	</body>
</html>