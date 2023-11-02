package controlado;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import modelo.Usuario;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Usuario usuario = new Usuario ("Pepe","pxpx");
		
		String contrasenaIndex = request.getParameter("contrasena");
		String nombreIndex = request.getParameter("nombre");
		
		/*String contraseñaUsuario = usuario.get_contraseña();*/
		//String nombreUsuario = usuario.get_nombre();
		
		if (usuario.validate(nombreIndex, contrasenaIndex)) {
			String rutaJsp= "/bien.jsp";
			RequestDispatcher pepe = getServletContext().getRequestDispatcher(rutaJsp);
			pepe.forward(request, response);
		}
		
	}

}
