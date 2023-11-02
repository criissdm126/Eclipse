package es.ciuedadescolar.ficherosSecuenciales2;

import java.io.Serializable;

public class Alumno implements Serializable {
	
	private static final long serialVersionUID = -7831163346259226667L;
	//private static final long serialVersionUID = 1L;
	
	private String expediente;
	private String nombre;
	private transient String password;
	private String apellido;
	
	// CONSTRUCTOR
	public Alumno(String expediente, String nombre, String pwd) {
		this.expediente = expediente;
		this.nombre = nombre;
		this.password = pwd;
	}
	
	// CONSTRUCTOR POR DEFECTO
	public Alumno(){
		
	}
	// GETTER Y SETTER
	public String getExpediente() {
		return expediente;
	}
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Alumno [expediente = " + expediente + ", nombre=  " + nombre + ", password = " + password + " ]";
	}

	
	
	

}
