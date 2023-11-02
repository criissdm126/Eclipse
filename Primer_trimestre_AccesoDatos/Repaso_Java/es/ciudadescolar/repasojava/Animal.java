package es.ciudadescolar.repasojava;

/*Definición de la clase Animal */

public class Animal {
	
	private String tipo; //doméstico,salvaje
	private String sexo; //macho,hembra
	public Animal (String tipo, String sexo) {
		this.tipo = tipo;
		this.sexo = sexo;
	}
	
	public Animal () {
		this.tipo = "salvaje";
		this.sexo = "macho";
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String toString() {
		return "Tipo: " + this.tipo + " - Sexo: "+ this.sexo + "\n";
	}
	
	/*el animal se echa a dormir*/
	public void duerme() {
		System.out.println("Zzzzzzz");
	}
	
	// El animal come
	public void come() {
	    System.out.println("El animal está comiendo.");
	}
}

