package AAD.UD02E01.CristinadeMaria;

public class Programa {
	

    public static void main(String[] args) {
        if (args.length == 1) {
            String rutaDirectorio = args[0];
            FicherosClase.recorrerDirectorio(rutaDirectorio);
        } else {
            System.out.println("Error. No se encuentra el directorio o no existe.");
        }
    }
}