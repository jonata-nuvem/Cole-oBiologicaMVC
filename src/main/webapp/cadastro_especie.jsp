<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cole��o Biol�gica</title>
</head>
<body>
<h1>Cole��o Biol�gica</h1>
<form action="EspecieController" method="POST">
	<input type="hidden" name="action" value="salvar"/>
	Nome cient�fico:<input type="text" name="nomeespecie"/><br/>
	Lote:<input type="text" name="lote"/><br/>
	Esp�cime(s):<input type="text" name="especimes"/><br/>
	<input type="submit" value="Salvar"/>
</form>

</body>
</html>