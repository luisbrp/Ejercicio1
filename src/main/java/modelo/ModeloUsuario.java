package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloUsuario extends Conector {
	PreparedStatement pst;
	ResultSet rs;
	
	public Usuario getUsuario(int id ) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();

		
		try {
			pst = conexion.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
			
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			
			while (rs.next()) {
		
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPassword(rs.getString("password"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return usuario;
	}
	public ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
				pst = conexion.prepareStatement("SELECT * FROM usuarios");
				
				pst.executeQuery();
				
				rs = pst.executeQuery();
				
				while(rs.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPassword(rs.getString("password"));
				usuarios.add(usuario);
				
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return usuarios;
	}
	
	public void eliminarUsuario (int id) {
		try {
			pst = conexion.prepareStatement("DELETE FROM usuarios WHERE id = ?");
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertarUsuario (Usuario usuario)  {
		
			try {
				pst = conexion.prepareStatement("INSERT INTO usuarios (nombre, password) VALUES (?,?)");
				
				pst.setString(1, usuario.getNombre());
				pst.setString(2, usuario.getPassword());

				pst.execute();	
			} catch (SQLException e) {
				e.printStackTrace();
		}
			
	}

}
