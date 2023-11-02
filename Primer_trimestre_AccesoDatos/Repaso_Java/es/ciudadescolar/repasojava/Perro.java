package es.ciudadescolar.repasojava;

/*Definición de la clase Perro */

public class Perro extends Animal implements Mascota {
    private int codigo;
    private String nombre;

    public Perro(String nombre, String sexo, int c) {
        super("doméstico", sexo); // Use the Animal constructor with parameters
        this.codigo = c;
        this.nombre = nombre;
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }

    //el perro emite sonido
    @Override
    public void hazRuido() {
        this.ladra();
    }

    //el perro ladra
    public void ladra() {
        System.out.println("Guau guau!");
    }

    //el perro come
    @Override
    public void come(String comida) {
        if (comida.equals("pescado")) {
            System.out.println("Pescado noooooo!");
        } else {
            super.come();
            System.out.println("comida rica!");
        }
    }

    public String toString() {
        return "Perro mascota - Nombre: " + nombre + " - Sexo: " + super.getSexo() + " - Código:" + getCodigo();
    }
}

/* Almacenar 3 gatos en un array y visualizarlo por pantalla. Los gatos se introducen por teclado.
 * Almacenar 3 perros en una colección y visualizarlo por pantalla.
 */