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
	<form method="post" action="InsertarUsuario">
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
    <div class="form-group">
    <label>Fecha:</label>
    <input type="date" name="fecha" required 
           class="form-control" 
           oninvalid="this.setCustomValidity('Por favor, ingresa una fecha validad)" 
           onchange="this.setCustomValidity('')" /><br />
  </div>
  <input type="submit" value="Guardar" class="btn btn-primary"/>
  <a href="VerUsuarios" class="btn btn-primary">Volver</a>
</form>


</body>
</html>