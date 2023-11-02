package AAD.UD02E01.CristinadeMaria;

import java.io.File;

public class FicherosClase {

    public static void recorrerDirectorio(String ruta) {
        File directorio = new File(ruta);

        if (!directorio.exists() || !directorio.isDirectory()) {
            System.err.println("No es un directorio o la ruta está mal puesta.");
            return;
        }

        mostrarInformacionDirectorio(directorio);

        File[] archivos = directorio.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    mostrarInformacionArchivo(archivo);
                } else if (archivo.isDirectory()) {
                    recorrerDirectorio(archivo.getAbsolutePath());
                }
            }
        }
    }

    private static void mostrarInformacionDirectorio(File directorio) {
        String atributos = (directorio.canRead() ? "|R" : "") + (directorio.canWrite() ? "|W" : "");
        System.out.println("D|" + directorio.getAbsolutePath() + "|" + atributos);
    }

    private static void mostrarInformacionArchivo(File archivo) {
        String atributos = (archivo.canRead() ? "|R" : "") + (archivo.canWrite() ? "|W" : "");
        if (archivo.isHidden()) {
            atributos += "|H";
        }
        System.out.println("F|" + archivo.getAbsolutePath() + "|" + atributos);
    }
}
