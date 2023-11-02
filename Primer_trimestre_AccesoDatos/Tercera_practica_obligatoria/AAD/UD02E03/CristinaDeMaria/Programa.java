package AAD.UD02E03.CristinaDeMaria;

import java.io.*;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
    	
        Scanner sc = null;
        RandomAccessFile fich = null;
        File fichero = null;

        if (args.length != 1) {
            System.out.println("Error,tienes que insertar un numero válido.");
        } else {
            fichero = new File(args[0]);
            if (fichero.exists()) {
                System.out.println("Error, el fichero ya existe");
            } else {
                try {
                    fich = new RandomAccessFile(fichero, "rw");
                    
                 // Escribir el abecedario en el fichero
                    fich.writeChars("abcdefghijklmnñopqrstuvwxyz");


                    fich.close();
                    System.out.println("Fichero creado");

                    fich = new RandomAccessFile(fichero, "rw");
                    System.out.println("El fichero: [ " + fichero.getAbsolutePath() + " ] ");
                    System.out.println("ocupa [" + fich.length() + " ] bytes.");
                    sc = new Scanner(System.in);
                    System.out.print("Ingrese un número (1-27) para obtener una letra del abecedario: ");
                    int posicion = sc.nextInt();

                    // Verificar que la posición esté dentro del rango válido
                    if (posicion >= 1 && posicion <= 27) {
                        // Calcular la posición en el fichero (cada letra ocupa 2 bytes)
                        long posicionEnFichero = (posicion - 1) * 2;
                        
                        // Mover el puntero a la posición deseada
                        fich.seek(posicionEnFichero);
                        
                        // Leer la letra
                        char letra = fich.readChar();
                        
                        System.out.println("Letra en la posición " + posicion + ": " + letra);
                    } else {
                        System.out.println("Número fuera del rango válido.");
                    }

                    // Mostrar la posición actual del puntero
                    System.out.println("Posición del puntero después de la lectura: " + fich.getFilePointer());

                    fich.close();
                } catch (FileNotFoundException e) {
                    System.out.println("El fichero no existe");
                } catch (IOException e) {
                    System.out.println("Error durante la escritura o lectura del fichero");
                }
            }
        }
    }
}

/* String "abecedario" uso de la clase java.io.RandomAccessFile 
 * posteriormente pida porteclado al ususario que indique el nº de letra del abecedario y el programa lo muestre.
 * El programa deberá mostrar el tamaño en bytes del fichero y posicióndel puntero, antes y después de realizar la correspondiente lectura.
 */
