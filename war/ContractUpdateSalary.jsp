<%@page import="com.myproject.service.ContractService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contract update</title>
</head>
	<body>
		<%ContractService accServ = new ContractService();
		Long salary;
		int condition = 1;
		
		
		try {
			salary = Long.valueOf(request.getParameter("salary"));
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
		accServ.updSalary(Long.valueOf(request.getParameter("salary")), Long.valueOf(request.getParameter("id")));		
		%>Updated!<br><%
		}
		
		%>
		
		
		<form action="/ContractList.jsp"><input type="submit" value="Back"></form>
	</body>
</html>
