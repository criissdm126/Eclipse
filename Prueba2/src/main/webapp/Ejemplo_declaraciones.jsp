
<!DOCTYPE html>
<html>

<body>

<h2 style="text-align:center">Ejemplo de métodos y llamadas</h2>

<%!
private static int resultado;

public static int suma (int num1, int num2) {
	resultado= num1+num2;
	return resultado;
}

public static int resta (int num1, int num2) {
	resultado= num1-num2;
	return resultado;
}

public static int multiplica (int num1, int num2) {
	resultado= num1*num2;
	return resultado;
}
	%>

la resta de 8 y 3 es <%=Calculadora.resta(8,3) %><br>
la multiplicación de 8 y 3 es <%=Calculadora.multiplica(8, 3) %>
</body>
</html>