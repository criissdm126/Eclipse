package Prueba_inicial;

public class Principal {

		 private String marca;
		    private String modelo;
		    private int año;

		    public Principal(String marca, String modelo, int año) {
		        this.marca = marca;
		        this.modelo = modelo;
		        this.año = año;
		    }

		    public String getMarca() {
		        return marca;
		    }

		    public String getModelo() {
		        return modelo;
		    }

		    public int getAño() {
		        return año;
		    }
		}
