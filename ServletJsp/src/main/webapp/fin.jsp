<%@page import="es.salesianos.repository.Repository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.util.LinkedList"%>
<%@ page import = "es.salesianos.repository.*,es.salesianos.model.*"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<b><%= request.getParameter("name") %></b>
<b><%= request.getAttribute("age") %></b>
<b><%= request.getParameter("course") %></b><br/>
<input type="button" value="Volver" onclick="self.location.href = 'datos.jsp'">
<form action="delete" method="post">
 <input value="Eliminar" type="submit">
 <input type="hidden" value="<%= request.getParameter("name") %>" name="name">
</form>
<table>
	<tr><td>Nombre</td><td>Edad</td><td>Curso</td><<td>Eliminar</td>
	</tr>
	<tr><td><%
		LinkedList<User> lista = new Repository().getUsuarios();
		for (int i = 0; i < lista.size(); i++) {
			out.println("<tr>");
			out.println("<td>" + lista.get(i).getName() + "</td>");
			out.println("<td>" + lista.get(i).getCourse() + "</td>");
			out.println("<td>" + lista.get(i).getDateOfBirth() + "</td>");
			out.println("<td><a href=./delete?name=" + lista.get(i).getName() + " >Eliminar</a></td>");
			out.println("</tr>");
		}
	%>
</table>

</body>
</html>