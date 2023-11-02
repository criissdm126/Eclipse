package Modelo;

public class Usuario {
	private String nombre;
	private String contraseña;
	
	public Usuario(String n, String c) {
		nombre = n;
		contraseña = c;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public boolean validar(String n, String c) {
		if(n.equals(nombre) && c.equals(contraseña))
			return true;
		else
			return false;
	}
}
