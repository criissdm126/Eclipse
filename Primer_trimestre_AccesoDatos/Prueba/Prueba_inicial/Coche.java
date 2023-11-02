package Prueba_inicial;

import java.util.ArrayList;
import java.util.Scanner;

public class Coche {
    public static void main(String[] args) {
        ArrayList<Principal> listaVehiculos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Dar de alta vehículo");
            System.out.println("2. Mostrar los vehículos");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Opción 1: Dar de alta vehículo
                    sc.nextLine(); // Consume newline
                    System.out.print("Ingrese la marca del vehículo: ");
                    String marca = sc.nextLine();
                    System.out.print("Ingrese el modelo del vehículo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Ingrese el año del vehículo: ");
                    int año = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    Principal vehiculo = new Principal(marca, modelo, año);
                    listaVehiculos.add(vehiculo);
                    System.out.println("Vehículo dado de alta exitosamente.");
                    break;

                case 2:
                    // Opción 2: Mostrar los vehículos
                    System.out.println("Lista de vehículos:");
                    for (Principal v : listaVehiculos) {
                        System.out.println("Marca: " + v.getMarca() + ", Modelo: " + v.getModelo() + ", Año: " + v.getAño());
                    }
                    break;

                case 3:
                    // Opción 3: Salir
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }
}
