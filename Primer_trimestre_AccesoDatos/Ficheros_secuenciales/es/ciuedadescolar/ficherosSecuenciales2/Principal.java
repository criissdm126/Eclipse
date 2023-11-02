package es.ciuedadescolar.ficherosSecuenciales2;

import java.io.*;

public class Principal {
	
	public static void main(String[] args) {
		
		File fich = new File("C:\\Users\\crist\\eclipse-workspace\\Primer_trimestre_AccesoDatos\\directorio2\\alumnos.dat");
		
		Alumno[] alumnos = {new Alumno("1001", "Manolo", "123"),
				new Alumno("1002", "Jacobo", "123"),
				new Alumno("1003", "Fermin", "123"),
				new Alumno("1004", "David", "123")	
		};
		
		FlujoBinario2 fb2 = new FlujoBinario2(fich);
		
		try {
			// fb2.escribirAlumnos(alumnos);
			fb2.leerAlumnos();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
