package AAD.UD02E02.CristinaDeMaria;

import java.io.File;

public class FicherosClase {

    public static void borrarDirectorio(String ruta) {
        File directorio = new File(ruta);

        if (!directorio.exists()) {
            System.out.println("Error: El directorio no existe.");
            return;
        }

        if (directorio.isDirectory()) {
            borrarContenidoDirectorio(directorio);
        }

        // Muestra la información antes de borrar el directorio
        System.out.println("D|" + directorio.getAbsolutePath() + "|Borrado");
        
        if (directorio.delete()) {
            System.out.println("Directorio borrado con éxito.");
        } else {
            System.out.println("Error al borrar el directorio.");
        }
    }

    private static void borrarContenidoDirectorio(File directorio) {
        File[] archivos = directorio.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    // Muestra la información antes de borrar el archivo
                    System.out.println("F|" + archivo.getAbsolutePath() + "|Borrado");
                    if (archivo.delete()) {
                        System.out.println("Archivo borrado con éxito.");
                    } else {
                        System.out.println("Error al borrar el archivo.");
                    }
                } else if (archivo.isDirectory()) {
                    borrarDirectorio(archivo.getAbsolutePath());
                }
            }
        }
    }
}