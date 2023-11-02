<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Cookie [] arrayCookie =request.getCookies();

for(Cookie coke:arrayCookie){
	//System.out.print(coke.getValue());
if(coke.getName().equals("nombre")){
	String piza = coke.getValue(); 
	if(piza.equals("Piza")){%>
	<h1>Has elegido <%= piza %></h1>
	
	<%}else if (piza.equals("Pasta")){
		%>
		<h1>Has elegido <%= piza %></h1>
		
		<%
	}else if(piza.equals("Pan")){
		%>
		<h1>Has elegido <%= piza %></h1>
		
		<%
	}
}
} %>


</body>
</html>