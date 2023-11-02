package PEPE;

import java.sql.ResultSet;
import java.util.ArrayList;
	import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {
	

	//variable que almacenará el pool de conexiones
	private DataSource origenDatos;
	
	//constructor que recibirá como parámetro el pool de conexiones
	public ModeloProductos(DataSource origenDatos) {
		this.origenDatos=origenDatos;
	}
	
	//nuestro modelo que se va a encargar de devolver una lista de productos
	public List<Productos> getProductos() throws Exception{
		//Creamos un arraylist, le hemos puesto el mismo nombre productos
		//no confundirlo con el de la clase Productos
		// en este arrayList guardaremos los productos
		List<Productos> productos = new ArrayList<>();
		java.sql.Connection miConexion=null;
		java.sql.Statement miStatement=null;
		ResultSet miResultset=null;
		
		//Establecemos la conexión, partimos del pool de conexion
		miConexion= origenDatos.getConnection();
		
		//Creamos la sentencia SQL y el statement
		String sql="select * from productos";
		miStatement= miConexion.createStatement();
		
		//Ejecutamos la sentencia SQL
		miResultset=miStatement.executeQuery(sql);
		
		//Recorremos el resultSet que hayamos obtenido
		//con un bucle vamos recorriendo los registros y
		//los añadimos en la lista de productos
		while (miResultset.next()) {
		//Se puede poner el getString con indices o
		// que coincida exactamente con el nombre del campo en la tabla
		//si pusieramos indices, el primer campo va con 0
		String c_art=miResultset.getString("codigoarticulo");
		String seccion=miResultset.getString("seccion");
		String n_art=miResultset.getString("nombrearticulo");
		
		String importado=miResultset.getString("importado");
		String p_orig=miResultset.getString("paisdeorigen");
		//Creamos un objeto de tipo Producto para agregarlo a nuestra lista productos
		Productos tempProd=new Productos(c_art,seccion,n_art,importado,p_orig);
		productos.add(tempProd);
		}
		return productos;
	}
}