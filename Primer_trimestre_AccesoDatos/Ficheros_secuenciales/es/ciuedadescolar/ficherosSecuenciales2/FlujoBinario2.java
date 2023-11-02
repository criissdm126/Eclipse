package es.ciuedadescolar.ficherosSecuenciales2;

import java.io.*;

public class FlujoBinario2 {
	
	private File ficheroalumno = null;
	
	
	// CONSTRUCTOR
	public FlujoBinario2(File fichero) {
		this.ficheroalumno = fichero;
	}
	
	public void escribirAlumnos(Alumno[] alumnos) throws IOException, FileNotFoundException {
		FileOutputStream fos = new FileOutputStream(ficheroalumno);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		for(Alumno al:alumnos) {
			oos.writeObject(al);
		}
		
		oos.flush();
		oos.close();
	}
	
	public void leerAlumnos() throws ClassNotFoundException, IOException{
		
		FileInputStream fis = new FileInputStream(ficheroalumno);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		
		// NO FUNCIONA EL MÉTODO POR DEVOLVER UNA ESTIMACIÓN 0 CON
		/*while(ois.available() > 0) {
			Alumno alumno = (Alumno) ois.readObject();	
			System.out.println(alumno);
			}*/
		
		// ois.close();
		
		try {
		while(true) {
			Alumno alumno = (Alumno) ois.readObject();	
			System.out.println(alumno);
		}
		}catch(EOFException e) {
			// ALCANZADO FINAL DE FICHERO. AL SER CONTROLADO, NO MUESTRO NADA.
			
		}finally {
			ois.close();
		}
	
		
	}

}
