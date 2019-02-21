<%@page import="com.myproject.model.Film"%>
<%@page import="java.util.List"%>
<%@page import="com.myproject.service.FilmService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All films</title>
</head>
<body>

<% FilmService accServ = new FilmService();
List<Film> accList = accServ.getAllFilms();%>
<b>Accounts:</b>
		<table>
		<%for(int i = 0; i < accList.size(); i++) { %>
			<tr>
				<td><%=accList.get(i).getId() %></td>
				<td><%=accList.get(i).getName() %></td>
				<td><%=accList.get(i).getGenre() %></td>
				<td><%=accList.get(i).getDescription() %></td>
				<td><%=accList.get(i).getMinutes() %></td>
				<td><a href="/FilmRead.jsp?id=<%=accList.get(i).getId() %>">Change or add contract</a></td>
			</tr>
		<%} %>
		</table>
		
		
		<form action="/FilmDelete.jsp" type="get">
     	Id for delete: <input type="text" name="id">
     	<input type="submit" value="delete">
    	</form>
    	<form action="/Film.html"><input type="submit" value="Back"></form>



</body>
</html>