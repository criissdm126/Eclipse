package es.ciuedadescolar.ficherosSecuenciales;

import java.io.*;

public class Principal {


		public static void main(String[] args) {
			
			FlujoBinario fb= new FlujoBinario();
			fb.setNombrefichero("C:\\Users\\crist\\eclipse-workspace\\Primer_trimestre_AccesoDatos\\directorio2\\numeros.dat");
			
			try {
				fb.crearFichero();
				fb.leerFichero();
			}
			catch (FileNotFoundException e) {
				System.out.println("Error, fichero inexistente. "+fb.getNombrefichero());
			}
			catch (IOException e) {
				System.out.println("Error durante la manipualción del fichero "+fb.getNombrefichero());
			}
		}

	}
