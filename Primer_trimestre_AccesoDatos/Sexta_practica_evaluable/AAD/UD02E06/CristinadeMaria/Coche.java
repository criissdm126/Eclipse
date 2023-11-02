package AAD.UD02E06.CristinadeMaria;

import java.io.Serializable;

public class Coche implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8487923350459287419L;
	// ATRIBUTOS
	private Integer id;
	private String marca;
	private String modelo;
	private float precio;
	
	
	// CONSTRUCTOR
	public Coche(Integer id, String marca, String modelo, float precio) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}
	
	// GETTER Y SETTER
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Concesionario [id = " + id + ", marca = " + marca + ", modelo = " + modelo + ", precio = " + precio + "]";
	}
}
