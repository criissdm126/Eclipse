package es.ciudadescolar.ficherosAD;

import java.io.*;
import java.util.*;
//E:\fich_acceso_aleatorio.dat
// C:\Users\crist\eclipse-workspace\Primer_trimestre_AccesoDatos

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = null; 
		RandomAccessFile fich = null;
		File fichero = null;
		
		if(args.length != 1) {
			System.out.println("Error de parametro, se espera un parametro con la ruta del fichero");
		}
		
		else {
			fichero = new File(args[0]);
			if(fichero.exists()) {
				System.out.println("Error de parametro, el fichero ya existe");
			
			}
			else {
				try {
					 fich = new RandomAccessFile(fichero, "rw");
					
					for (int i=1; i<=100; i++) {
						fich.writeByte(i);
					}
					
					fich.close();
					System.out.println("Fichero creado");
					
					fich = new RandomAccessFile(fichero, "rw");
					System.out.println("El fichero: [ " + fichero.getAbsolutePath() + " ] ocupa [" + fich.length() + " ] bytes.");
					int posicion = -1;
					do { 
						try {
												sc = new Scanner(System.in);
					System.out.println("Indique la posición que quiere leer: [0 - " + fich.length() + " ] bytes");
					posicion = sc.nextInt();
					sc.close();
						}catch(InputMismatchException e) {
							System.out.println();
						}

					
					
					}while(posicion < 0 || posicion > fich.length());
					

					fich.seek(posicion -1); // posiciono el puntero en la posicion a leer.
					
					System.out.println("Posicion del puntero [ " + fich.getFilePointer() + " ]");
					System.out.println("El byte en esa posición es: [ " + fich.readByte() + " ]");
					System.out.println("Lectura realizada, el puntero ahora está en:  [ " + fich.getFilePointer() + " ]");
					
					
				}catch(FileNotFoundException e){
					System.out.println("El fichero no existe");
				}catch(IOException e) {
					System.out.println("Error durante la escritura del fichero");
				} finally {
					
					try {
						fich.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
