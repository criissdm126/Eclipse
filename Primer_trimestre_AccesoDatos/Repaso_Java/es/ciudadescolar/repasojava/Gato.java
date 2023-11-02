package es.ciudadescolar.repasojava;

/*Definición de la clase Gato*/

public class Gato extends Animal implements Mascota {
    private int codigo;

    public Gato(String sexo, int c) {
        super("doméstico", sexo); // Use the Animal constructor with parameters
        this.codigo = c;
    }

	@Override
	public int getCodigo() {
		return this.codigo;
	}
	
	//el gato emite sonido
	@Override
	public void hazRuido() {
		this.maulla();
		this.ronronea();
	}
	
	//el gato maulla
	public void maulla() {
		System.out.println("Miauuuu");
	}
	
	//el gato ronronea
	public void ronronea() {
		System.out.println("mrrrrrr");
	}
	
	//el gato come
	@Override
	public void come(String comida) {
		if (comida.equals("pescado")) {
			super.come();
			System.out.println("Que rico el pescado!, gracias");
		} 
		else {
			System.out.println("Lo siento, yo solo como pescado");
		}
	}
	
	public String toString() {
		return "Gato mascota" + " - Sexo:"+ super.getSexo() +" - Código:" + getCodigo();
	}
}