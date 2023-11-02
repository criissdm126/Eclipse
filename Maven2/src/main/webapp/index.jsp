<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

<%@ page import="java.util.*, PEPE.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<%
//obtenemos los productos del controlador (Servlet)
//utilizamos el nombre que le dimos en el controlador,
//es la lista que viaja desde el controlador a la página JSP
List<Productos> losProductos=(List<Productos>) request.getAttribute("LISTAPRODUCTOS");
%>
<!-- En el body hacemos una prueba para ver si carga los datos-->
<!--En este JSP ya pondriamos la presentación de los datos en bonito-->
<%= losProductos %>

<body>
<table>
<tr>
<td>Código artículo</td>
<td>Sección</td>
<td>Nombre artículo</td>
<td>Importado</td>
<td>Pais</td>
</tr>
<% for(Productos tempProd : losProductos){ %>
<tr>
<td><%=tempProd.getCodigo() %></td>
<td><%=tempProd.getSeccion() %></td>
<td><%=tempProd.getNombre() %></td>
<td><%=tempProd.getImportado() %></td>
<td><%=tempProd.getPais() %></td>
</tr>
<%} %>
</table>
</body>
</body>
</html>