package controlador;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class InsertarUsuario
 */
@WebServlet("/InsertarUsuario")
public class InsertarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("InsertarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
		Usuario usuario = new Usuario();
		ModeloUsuario modeloUsuario = new ModeloUsuario();

		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String fechaR = request.getParameter("fecha");
		
		
		usuario.setNombre(nombre);
		usuario.setPassword(password);

		
		try {
			Date fecha = (Date) fechaFormato.parse(fechaR);
			usuario.setFecha(fecha);
		} catch (ParseException e) {
		    
		}
		modeloUsuario.conectar();
		modeloUsuario.insertarUsuario(usuario);
		modeloUsuario.cerrar();
		
		response.sendRedirect("Principal.jsp");
	}

}
