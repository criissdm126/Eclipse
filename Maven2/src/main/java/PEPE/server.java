package PEPE;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class server
 */
public class server extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public server() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			//java.sql.Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","");
		
			PrintWriter salida= response.getWriter();
			response.setContentType("text/plain");
			
			//Crear conexión con BD
			java.sql.Connection miConexion=null;
			java.sql.Statement miStatement=null;
			java.sql.ResultSet miResultset=null;
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
					miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","");
					String miSql="select * from productos";
					miStatement=miConexion.createStatement();
					miResultset=miStatement.executeQuery(miSql);
					System.out.println(miStatement);
					//System.out.println(nombre_articulo);
					while (miResultset.next()) {
						String nombre_articulo=miResultset.getString(3);
						//salida.println(nombre_articulo);
						System.out.println(nombre_articulo);
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
