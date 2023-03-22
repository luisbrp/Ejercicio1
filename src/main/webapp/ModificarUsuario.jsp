<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Modificar Usuario</title>
</head>
<body>
<h1>Modificar Usuario</h1>
<% Usuario usuario = (Usuario)  request.getAttribute("usuario"); %>
	<form method="post" action="ModificarUsuario">
  <div class="form-group">
    <label>Nombre:</label>
    <input type="text" name="nombre" required 
           class="form-control" 
           oninvalid="this.setCustomValidity('Por favor, ingresa un nombre válido')" 
           onchange="this.setCustomValidity('')" /><br />
  </div>
  <div class="form-group">
    <label>Password:</label>
    <input type="password" name="password" required 
           class="form-control" 
           oninvalid="this.setCustomValidity('Por favor, ingresa una contraseña válida')" 
           onchange="this.setCustomValidity('')" /><br />
  </div>
  <input type="submit" value="Guardar" class="btn btn-primary" />
  <a href="VerUsuarios" class="btn btn-primary">Volver</a>
</form>
</body>
</html>