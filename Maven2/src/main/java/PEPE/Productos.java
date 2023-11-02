package PEPE;

public class Productos {

	private String codigo;
	private String seccion;
	private String nombre;
	private String importado;
	private String pais;
	
	public Productos (String codigo,String seccion, String nombre, String importado, String pais) {
		this.codigo=codigo;
		this.seccion=seccion;
		this.nombre=nombre;
		this.importado=importado;
		this.pais=pais;
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImportado() {
		return importado;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", seccion=" + seccion + ", nombre=" + nombre + ", importado="
				+ importado + ", pais=" + pais + "]";
	}
	
	
	
	
	
	
}
