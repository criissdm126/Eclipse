package PEPE;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControladorProductos {

	private static final long serialVersionUID = 1L;

	//variable de tipo ModeloProductos que hemos creado anteriormente
	private ModeloProductos modeloProductos;
	
	@Resource(name="jdbc/Productos")
	private DataSource miPool;
	//El método init será desde el cual arrancará nuestra aplicación
	//equivalente al main podríamos decir
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		init();
		try {
		modeloProductos=new ModeloProductos(miPool);
		
		}catch (Exception e) {
		throw new ServletException(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		//creamos lista de productos
		List<Productos> productos;
		try {
			//en la lista almacenamos lo que nos devuelve el modelo
			productos=modeloProductos.getProductos();
			//agregamos la lista al request
			//LISTAPRODUCTOS es el nombre para identificarla después desde el JSP
			request.setAttribute("LISTAPRODUCTOS", productos);
			//enviamos el request a la página jsp
			jakarta.servlet.RequestDispatcher miDispatcher= request.getRequestDispatcher("/ListaProductos.jsp");
			miDispatcher.forward(request, response);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
