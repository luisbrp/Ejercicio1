package modelo;

import java.sql.Date;
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
				usuario.setFecha(rs.getDate("fecha"));
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
				usuario.setFecha(rs.getDate("fecha"));
				
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
				pst = conexion.prepareStatement("INSERT INTO usuarios (nombre, password, fecha) VALUES (?,?,?)");
				
				pst.setString(1, usuario.getNombre());
				pst.setString(2, usuario.getPassword());
				if(usuario.getFecha() != null) {
				    pst.setDate(3, new Date(usuario.getFecha().getTime()));
				} else {
				    pst.setNull(3, java.sql.Types.DATE);
				}

				pst.execute();	
			} catch (SQLException e) {
				e.printStackTrace();
		}
			
	}
	
	public void modificarUsuario (Usuario usuario) {
	
		try {
			pst = conexion.prepareStatement("UPDATE usuarios SET nombre=?, password=? WHERE id=?");
			
			
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getPassword());
			pst.setDate(3, new Date(usuario.getFecha().getTime()));
			pst.setInt(4, usuario.getId());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
