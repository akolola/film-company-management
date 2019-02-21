<%@page import="com.myproject.service.FilmService"%>
<%@page import="com.myproject.model.Contract"%>
<%@page import="com.myproject.service.ContractService"%>
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
		Long contractId;
		int condition = 1;
		
		
		try {
			contractId = Long.valueOf(request.getParameter("ContractId"));
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
		accServ.addContract(Long.valueOf(request.getParameter("ContractId")),Long.valueOf(request.getParameter("id")));
		%><h2>Added</h2><br><%
		}
		%>
	</body>
</html>