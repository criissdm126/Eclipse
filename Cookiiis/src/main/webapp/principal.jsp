<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Selecciona tu comida favorita:</h1>

<form action="coqui" method="post">
<select name="select" >
	<option value="Piza">Pizza</option>
	<option value="Pasta">Pasta</option>
	<option value="Pan">Pan</option>
</select>
<input type="submit" value="enviar">
</form>
</body>
</html>