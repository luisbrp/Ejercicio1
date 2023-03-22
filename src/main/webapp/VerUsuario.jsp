<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<div>
<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %> 
		<h2>Información del usuario:</h2>
		<p>Id: <%out.println(usuario.getId());%></p>
		<p>Nombre: <%out.println(usuario.getNombre());%></p>
		<p>Contraseña: <%out.println(usuario.getPassword());%></p>
	</div>
	<a href="VerUsuarios" class="btn btn-primary">Volver</a>
</body>
</html>