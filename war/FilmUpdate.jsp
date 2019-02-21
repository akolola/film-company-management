<%@page import="com.myproject.service.FilmService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<%FilmService accServ = new FilmService();
		if (request.getParameter("name")!=null){
			accServ.updName(request.getParameter("name"), Long.valueOf(request.getParameter("id")));	
			}
		if (request.getParameter("genre")!=null){
		    accServ.updGenre(request.getParameter("genre"), Long.valueOf(request.getParameter("id")));	
			}
		if (request.getParameter("description")!=null){
		accServ.updDescription(request.getParameter("description"), Long.valueOf(request.getParameter("id")));
		}
		if (request.getParameter("minutes")!=null){
			
			Long minutes;
			int condition = 1;
			
			
			try {
				minutes = Long.valueOf(request.getParameter("minutes"));
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
				accServ.updMinutes(Integer.valueOf(request.getParameter("minutes")), Long.valueOf(request.getParameter("id")));			
			%>Updated!<br><%
			}
			//resp.sendRedirect("/Register");	
		}
		%>
		<form action="/FilmList.jsp"><input type="submit" value="Back"></form>
	</body>
</html>