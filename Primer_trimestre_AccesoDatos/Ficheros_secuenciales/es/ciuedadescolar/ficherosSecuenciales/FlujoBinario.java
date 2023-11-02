package es.ciuedadescolar.ficherosSecuenciales;

import java.io.*;

public class FlujoBinario {
	private String nombrefichero;
	
	
	// GETTER Y SETTER
	public String getNombrefichero() {
		return nombrefichero;
	}

	public void setNombrefichero(String nombrefichero) {
		this.nombrefichero = nombrefichero;
	}
	
	//MÉTODO CREAR FICHERO
	public void crearFichero() throws IOException {
		
		FileOutputStream file = null;
		BufferedOutputStream buffer = null;
		DataOutputStream data = null;
		
		
			file= new FileOutputStream(nombrefichero); //fos
			buffer = new BufferedOutputStream(file); //bos
			data = new DataOutputStream(buffer); //dos
			
			for (int i=1; i<=100; i++) {
				data.write(i); //dos
			}
			
			
			data.flush();//siempre que use buffers tengo que vaciarlo antes de cerrar
			data.close();
			
		
	}
	
	
	// MÉTODO LEER FICHERO
	public void leerFichero() throws IOException {
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		DataInputStream dis=null;
		
		
			fis= new FileInputStream(nombrefichero);
			bis= new BufferedInputStream(fis);
			dis= new DataInputStream(bis);
			
			/*while(true){
				int dato=dis.readInt();
				System.out.println(dato);
			}*/
			while(dis.available()>0){
				int dato=dis.readInt();
				System.out.println(dato);
			}
		 
		
	}
}