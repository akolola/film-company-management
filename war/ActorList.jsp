<%@page import="com.myproject.model.Actor"%>
<%@page import="java.util.List"%>
<%@page import="com.myproject.service.ActorService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All actors</title>
</head>
<body>

<% ActorService accServ = new ActorService();
List<Actor> accList = accServ.getAllActors();%>
<b>Accounts:</b>
		<table>
		<%for(int i = 0; i < accList.size(); i++) { %>
			<tr>
				<td><%=accList.get(i).getId() %></td>
				<td><%=accList.get(i).getName() %></td>
				<td><%=accList.get(i).getEmail() %></td>
				<td><a href="/ActorRead.jsp?id=<%=accList.get(i).getId() %>">Change or add contract</a></td>
			</tr>
		<%} %>
		</table>
		
	    <form action="/ActorDelete.jsp" type="get">
     	Id for delete: <input type="text" name="id">
     	<input type="submit" value="delete">
    	</form>   	
		<form action="/Actor.html"><input type="submit" value="Back"></form>
		


</body>
</html>