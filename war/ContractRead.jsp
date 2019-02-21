<%@page import="com.myproject.model.Contract"%>
<%@page import="com.myproject.service.ContractService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>To change</title>
</head>
	<body>
		<%ContractService accServ = new ContractService();
		Contract acc = accServ.readContract(Long.valueOf(request.getParameter("id")));
		%>
		Id = <b><%=acc.getId() %></b><br><br>
		Input salary <b></b><form action="/ContractUpdateSalary.jsp" method="get">
										 <input type="text" name="salary" value=<%=acc.getSalary()%>><input type="submit" value="Change">
										 <input type="hidden" name="id" value="<%=acc.getId() %>"></form><br>		
		Date <b><%=acc.getDateBegin() %></b><br>

	
		<form action="/ContractList.jsp"><input type="submit" value="Back"></form>
	</body>
</html>