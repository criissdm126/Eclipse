package AAD.UD02E04.CristinaDeMaria;

import java.io.*;

public class Modulo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7756542460969264898L;
	
	// VARIABLES
	String cont; // CONTRASEÑA
	String modulo; // NOMBRE MODULO
	int horas; // HORAS SEMANALES
	int curso; // CURSO
	String profe; // PROFESOR
	
	// CONSTRUCTOR
	public Modulo(String nom, int horas, int curso, String profe) {
		// this.cont = cont;
		this.modulo = nom;
		this.horas = horas;
		this.curso = curso;
		this.profe = profe;
	}
	
	// GETTER Y SETTER
	// CONTRASEÑA
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}

	
	// NOMBRE MODULO
	public String getNom() {
		return modulo;
	}
	public void setNom(String nom) {
		this.modulo = nom;
	}
	
	// HORAS SEMANALES
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	// CURSO
	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	// PROFESOR
	public String getProfe() {
		return profe;
	}

	public void setProfe(String profe) {
		this.profe = profe;
	}
	
	
	// TO STRING
	@Override
	public String toString() {
		
		// Módulo profesional|horas semanales|profesor|curso|contraseña AV
		return "Modulo = Modulo profesional [ " + modulo + " ], horas semanales [ " + horas + " ], profesor [ " + profe + " ], curso [ " + curso + " ], contraseña [ " + cont + " ]";
	}
	private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(modulo);
        out.writeObject(horas);
        out.writeObject(curso);
        out.writeObject(profe);
        // Do not write "contraseña AV"
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        modulo = (String) in.readObject();
        horas = (int) in.readObject();
        curso = (int) in.readObject();
        profe = (String) in.readObject();
        // Read and discard "contraseña AV"
        in.readObject();
    }
}
