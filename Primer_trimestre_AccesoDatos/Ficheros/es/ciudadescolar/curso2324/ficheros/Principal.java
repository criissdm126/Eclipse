package es.ciudadescolar.curso2324.ficheros;

import java.io.*;
import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean salir = false;
		int opcion;
		File dirActual = new File(System.getProperty("user.dir"));
		File fichero  = null;
		File directorio  = null;
		
		while(!salir) {
			System.out.println("Elija una opción: ");
			System.out.println("1. Modificar directorio de trabajo.");
			System.out.println("2. Crear un nuevo directorio.");
			System.out.println("3. Crear un nuevo fichero.");
			System.out.println("4. Renombrar fichero.");
			System.out.println("5. Borrado de ficheros.");
			System.out.println("6. Borrado de un directorio.");
			System.out.println("7. Listar contenido de un directorio.");
			System.out.println("8. Ver propiedades de un fichero.");
			System.out.println("9. Salir del programa.");
			
			try {
				
			System.out.println("Seleccione la opción deseada: ");
			opcion = sc.nextInt();
			
			switch (opcion) {
			
			case 1:
				//System.out.println("El directorio actual de trabajo es: " + System.getProperty("user.dir"));
				System.out.println("Introduzca un nuevo directorio:");
				String ruta = sc.next();
				
				//comprobación
				if(!new File(ruta).exists()) {
					System.out.println("El directorio indicado no existe: " + ruta);
				}
				else {
					dirActual = new File(ruta);
				}
				break;
				
			case 2:
				System.out.println("Ponga el nombre del nuevo directorio: ");
				String nomDir = sc.next();
				directorio  = new File(dirActual, nomDir);
				directorio.mkdir();
				System.out.println("Se ha creado el directorio correctamente: " + directorio.getAbsolutePath());
				break;
				
			case 3:
				System.out.println("Ponga el nombre del nuevo fichero: ");
				String nomfich = sc.next();
				fichero  = new File(dirActual, nomfich);
				try {
					fichero.createNewFile();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Error durante la creación del fichero.");
				}
				
				break;

			case 4:
				System.out.println("Nombre del fichero original:");
				String oldfich = sc.next();
				fichero = new File(dirActual, oldfich);
				if(fichero.exists() && fichero.isFile()) {
					System.out.println("Introduzca el nuevo nombre para el fichero:");
					String newfich = sc.next();
					File ficherorenombrado = new File(dirActual, newfich);
					// fichero.renameTo(new File(dirActual, newfich));
					fichero.renameTo(ficherorenombrado);
					System.out.println("Se ha renombrado el fichero correctamente: " + fichero.getAbsolutePath());
				}
				else {
					System.out.println("Error, el fichero original no existe");
				}
				break;
				
			case 5:
				System.out.println("Que fichero te gustaría borrar:");
				String borfich = sc.next();
				fichero = new File(dirActual, borfich);
				if(fichero.exists() && fichero.isFile()) {
					fichero.delete();
					System.out.println("Se ha borrado correctamente." + fichero.getAbsolutePath());
				}
				else {
					System.out.println("No se pudo borrar el fichero");
				}
				break;
				
			case 6:
				System.out.println("Que directorio VACIO te gustaría borrar:");
				String bordir = sc.next();
				//C:\Users\crist\eclipse-workspace\Primer_trimestre_AccesoDatos\directorio1
				directorio = new File(dirActual, bordir);
				if(directorio.exists() && directorio.isDirectory() && directorio.list().length == 0) {
					directorio.delete();
					System.out.println("Se ha borrado correctamente." + directorio.getAbsolutePath());
				}
				else {
					System.out.println("No se pudo borrar el directorio ya que tiene contenido.");
				}
				break;
				
			case 7:
				System.out.println("Introduzca el nombre del directorio a listar:");
				String listdir = sc.next();
				directorio = new File(dirActual, listdir);
				if (!directorio.exists()) {
					System.out.println("Error, el directorio no existe.");
				}
				else {
					if(!directorio.isDirectory()) {
						System.out.println("No se trata d eun directorio");
					}
					else {
						File[] ficheros = directorio.listFiles();
						if(ficheros.length == 0) {
							System.out.println("El directorio está vacío.");
						} 
						else {
							for(File fich:ficheros) {
								System.out.println(fich.getName());
							}
						}
					}
				}
				break;
				// poder ver lo que hay dentro de newdir2, que también acceda ahí
				
			case 8:
				System.out.println("Nombre dle fichero a consultar");
				String confich = sc.next();
				fichero = new File(dirActual, confich);
				if(fichero.exists() && fichero.isFile()) {
					String condiciones = new String();
					
					if(fichero.canRead()) {
						condiciones = condiciones + "|lectura";
					}
					else {
						condiciones = condiciones + "|";
					}
					
					if(fichero.canWrite()) {
						condiciones = condiciones + "|escritura";
					}
					else {
						condiciones = condiciones + "|";
					}
					
					if(fichero.isHidden()) {
						condiciones = condiciones + "|oculto";
					}
					else {
						condiciones = condiciones + "|";
					}
					
					System.out.println(fichero.getName() + condiciones);
				}
				else {
					System.out.println("No se encontró el fichero");
				}
				
				break;
				
			case 9:
				salir = true;
				break;
			}
			
			}catch(InputMismatchException e) {
				System.out.println("Tienes que introducir un número.");
				sc.next();
			} 
		}
		
		sc.close();	

	}

}