package modelo;

public class Usuario {

	private String nombre;
	private String contrasena;
	
	public Usuario (String name, String passwd){
		nombre = name;
		contrasena = passwd;
	}
	
	public String  get_nombre () {
		return nombre;
	}
	
	public String  get_contraseña () {
		return contrasena;
	}
	
	public void set_nombre (String n) {
		nombre = n;
	}
	
	public void set_contraseña (String p) {
		contrasena = p;
	}
	
	public boolean validate (String n, String p) {
		if (n.equals(nombre) && p.equals(contrasena)) {
			return true ;
		}else return false;
	}
}