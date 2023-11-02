package server;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.sql.DataSource;

/**
 * Servlet implementation class metodos
 */
public class metodos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public metodos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  //Definimos el DataSource
  		@Resource(name="jdbc/productos")
  		private DataSource miPool;
  		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Crear el objeto printWriter
		PrintWriter salida= response.getWriter();
		response.setContentType("text/plain");
		
		//Crear conexión con BD
		java.sql.Connection miConexion=null;
		java.sql.Statement miStatement=null;
		java.sql.ResultSet miResultset=null;
		
		
		try {
				miConexion=miPool.getConnection();
				String miSql="select * from productos";
				miStatement=miConexion.createStatement();
				miResultset=miStatement.executeQuery(miSql);
				
				while (miResultset.next()) {
					String nombre_articulo=miResultset.getString(3);
					salida.println(nombre_articulo);
				}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
