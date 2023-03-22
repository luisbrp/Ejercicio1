package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		
		modeloUsuario.conectar();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuario = new Usuario();
		
		usuario = modeloUsuario.getUsuario(id);
		
		modeloUsuario.cerrar();
		
		
		request.setAttribute("usuario", usuario);
		request.setAttribute("password", usuario);
		
		request.getRequestDispatcher("ModificarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		
		
		int id = Integer.parseInt( request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		usuario.setId(id);
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		
		
		modeloUsuario.conectar();
		
		modeloUsuario.modificarUsuario(usuario);
		
		modeloUsuario.cerrar();
		
		response.sendRedirect("VerUsuarios");
	}

}
