package Despliegue;

public class Calculadora {

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
}
