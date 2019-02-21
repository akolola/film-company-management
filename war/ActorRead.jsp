<%@page import="com.myproject.service.FilmService"%>
<%@page import="com.myproject.model.Film"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.myproject.model.Contract"%>
<%@page import="com.myproject.service.ContractService"%>
<%@page import="com.myproject.model.Actor"%>
<%@page import="com.myproject.service.ActorService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>To change</title>
</head>
	<body>
		<%ActorService accServ = new ActorService();
		
		Actor acc = accServ.readActor(Long.valueOf(request.getParameter("id")));
		
		%>
		Id = <b><%=acc.getId() %></b><br><br>
		Input name<b></b><form action="/ActorUpdate.jsp" method="get">
										 <input type="text"  name="name" value=<%=acc.getName()%>><br><br>
										 
		Input email<b></b><br>
										 <input type="text" name="email" value=<%=acc.getEmail()%>><input type="submit" value="Change">
										 <input type="hidden" name="id" value="<%=acc.getId() %>"></form><br>
		Date  <b><%=acc.getDate() %></b><br><br> 
		
		
		
		Add Contract <b></b>      <form action="/ActorAddContract.jsp" method="get">
										 <input type="text" name="ContractId"><input type="submit" value="Add">
										 <input type="hidden" name="id" value="<%=acc.getId() %>"></form><br>
										 
		To see all contacts
		
       <a href="ContractList.jsp">List of contracts</a><br><br>
    
       
     
      
      To see all contracts of <%=acc.getName() %>

	<%
		
		ContractService contractServ = new ContractService();
		List<Long> ids = acc.getContractIds();
		List<Contract> contracts = new ArrayList<Contract>();
		for(Long i:ids) {
			contracts.add(contractServ.readContract(i));
		}
		FilmService filmServ = new FilmService();
		Film film = new Film();%>
	<form action="/ContractRead.jsp" method="get">
		<select name="id">
		<%for(Contract contract: contracts)
		{ %>
			
			<option value="<%=contract.getId() %>"><%=contract.getId() %>, <%=contract.getSalary() %>, <%=contract.getDateBegin() %></option>
		<%} %>
		</select>
		<input type="submit" value="View">
	</form><br>

	
		<form action="/ActorList.jsp"><input type="submit" value="Back"></form>

		
	</body>
</html>