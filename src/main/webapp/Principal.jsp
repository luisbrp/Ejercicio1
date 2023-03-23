<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   	pageEncoding="ISO-8859-1"
    %>
 <%@ page import="java.util.ArrayList"%>
 <%@ page import="modelo.Usuario"%>
 <%@ page import="modelo.ModeloUsuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>Ver Usuarios</title>
</head>
<body>
<%
  ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
%>
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th>Id</th>
      <th>Nombre</th>
      <th>Acciones</th>
      <th><a href="InsertarUsuario" class="btn btn-primary ">InsertarUsuario</a></th>
    </tr>
  </thead>
  <tbody>
    <% for (Usuario usuario : usuarios) { %>
      <tr>
        <td><%= usuario.getId() %></td>
        <td><%= usuario.getNombre() %></td>
         <td><a href="VerUsuario?id=<% out.println(usuario.getId()); %>" class="btn btn-primary ">Ver</a>
      	 <a href="ModificarUsuario?id=<% out.println(usuario.getId()); %>" class="btn btn-success ">Editar</a> 
      	<a href="EliminarUsuario?id=<% out.println(usuario.getId()); %>" class="btn btn-danger" >eliminar </a></td>
      </tr>
    <% } %>
  </tbody>
</table>
</body>
</html>