<%@page import="com.myproject.model.Contract"%>
<%@page import="java.util.List"%>
<%@page import="com.myproject.service.ContractService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All contracts</title>
</head>
<body>

<% ContractService accServ = new ContractService();
List<Contract> accList = accServ.getAllContracts();%>
<b>Accounts:</b>
		<table>
		<%for(int i = 0; i < accList.size(); i++) { %>
			<tr>
				<td><%=accList.get(i).getId() %></td>
				<td><%=accList.get(i).getSalary() %></td>
				<td><%=accList.get(i).getDateBegin() %></td>
				<td><%=accList.get(i).getDateEnd() %></td>
				<td><a href="/ContractRead.jsp?id=<%=accList.get(i).getId() %>">Change</a></td>
			</tr>
		<%} %>
		</table>
		<form action="/ContractDelete.jsp" type="get">
     	Id for delete: <input type="text" name="id">
     	<input type="submit" value="delete">
    	</form>
        <form action="/Contract.html"><input type="submit" value="Back"></form>

</body>
</html>