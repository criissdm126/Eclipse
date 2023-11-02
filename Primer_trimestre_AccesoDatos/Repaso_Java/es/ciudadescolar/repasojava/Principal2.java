package es.ciudadescolar.repasojava;

import java.util.*;

public class Principal2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Almacenar 3 gatos en un array
        Gato[] gatos = new Gato[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce el nombre del gato " + (i + 1) + ":");
            String nombre = sc.nextLine();
            System.out.println("Introduce el codigo del gato " + (i + 1) + ":");
            int codigo = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            gatos[i] = new Gato(nombre, codigo);
        }
        
        // Almacenar 3 perros en una colección (ArrayList)
        ArrayList<Perro> perros = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce el nombre del perro " + (i + 1) + ":");
            String nombre = sc.nextLine();
            System.out.println("Introduce el sexo del perro " + (i + 1) + ":");
            String sexo = sc.nextLine();
            System.out.println("Introduce el codigo del perro " + (i + 1) + ":");
            int codigo = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            perros.add(new Perro(nombre, sexo, codigo)); // Use the correct constructor
        }

        // Mostrar los gatos almacenados
        System.out.println("Gatos:");
        for (Gato gato : gatos) {
            System.out.println(gato.toString());
        }

        // Mostrar los perros almacenados
        System.out.println("\nPerros:");
        for (Perro perro : perros) {
            System.out.println(perro.toString());
        }
        
        sc.close();
    }
}
