package AAD.UD02E02.CristinaDeMaria;

public class Programa {

	    public static void main(String[] args) {
	        if (args.length != 1) {
	            System.out.println("Error: Debe proporcionar la ruta del directorio a borrar.");
	        } else {
	            String rutaDirectorio = args[0];
	            FicherosClase.borrarDirectorio(rutaDirectorio);
	           
	        }
	    }
	}