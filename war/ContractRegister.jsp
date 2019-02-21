<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register of contract</title>
</head>
<body>
<form action='/newCon' method="post">
<b>Insert here</b><br>
Salary<br><input type='text' name='salary'><br>
Id of actor<br><input type='text' name='actorId'><br>
Id of film<br><input type='text' name='filmId'><br>
<input type='submit' value='Save'>
<br>

</form>
<form action="/Film.html"><input type="submit" value="Back"></form>

<table>
      <tr>
        <td colspan="2" style="font-weight:bold;"></td>        
      </tr>
       <tr>
        <td><a href="ActorList.jsp">List of actors</a></td>
      </tr>
     <tr>
        <td><a href="FilmList.jsp">List of films</a></td>
      </tr>
 </table>
 
</body>
</html>