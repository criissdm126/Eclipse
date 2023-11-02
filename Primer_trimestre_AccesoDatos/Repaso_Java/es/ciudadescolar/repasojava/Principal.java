package es.ciudadescolar.repasojava;

public class Principal {

    public static void main(String[] args) {

        System.out.println();
        Gato miGato = new Gato("macho", 1);

        System.out.println(miGato);
        miGato.hazRuido();
        miGato.come("pescado");

        System.out.println();

        // Update the constructor for Perro
        Perro miPerro = new Perro("Max", "macho", 1);

        System.out.println(miPerro);
        miPerro.hazRuido();
        miPerro.come("pescado");
        miPerro.come("carne");

        System.out.println();

        Mascota garfield = new Gato("macho", 2);

        System.out.println(garfield);
        garfield.come("carne");
    }
}
