<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register of film</title>
</head>
<body>
<form action='/newFil' method="post">
<b>Insert here</b>
<table>
<tr>
<td>Name:</td>
<td><input type='text' name='name'></td>
</tr>
<tr>
<td>Genre:</td> 
<td><input type='text' name='genre'></td> 
</tr>
<tr>
<td>Description:</td>
<td> <input type='text' name='description'></td> 
</tr>
<tr>
<td>Minutes:</td><td> <input type='text' name='minutes'></td></tr> 
<tr><td><input type='submit' value='Save'></td></tr>
</table>
</form>
<form action="/Film.html"><input type="submit" value="Back"></form>
</body>
</html>