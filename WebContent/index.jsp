<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; utf-8">
		<title>Insert title here</title>
		<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="container col-md-5 col-md-offset-4 col-sm-offset-1 col-xs-offset-1">


			<h1>Formulário de Cadastro</h1>
			<hr />
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Cadastrar</th>
						<th>listar</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><a href="formCadastro.jsp">Cadastrar Cliente</a></td>
						<td><a href="cliente">Listar Clientes</a></td>
					</tr>
					<tr>
						<td><a href="funcionario?acao=cadastrar">Cadastrar Funcionario</a></td>
						<td><a href="funcionario">Listar Funcionarios</a></td>
					</tr>
				</tbody>	
			</table>
			
		</div>
	</body>
</html>
