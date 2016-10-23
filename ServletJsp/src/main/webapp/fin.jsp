<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<input type="button" value="Eliminar usuario" onclick="self.location.href = 'eliminar.jsp'">
</body>
</html>