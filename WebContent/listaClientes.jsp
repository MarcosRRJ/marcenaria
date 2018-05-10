<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.umc.marcenaria.modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">

		<%
			ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) request.getAttribute("listaCliente");
		%>

		<table class="table table-striped">
			<thead>
				<th>ID</th>
				<th>Login</th>
				<!-- <th>Telefone</th>
                 <th>Endere�o</th> -->
				<th>Alterar</th>
				<th>Desabilitar</th>

			</thead>
			<tbody>
				<%
					if (listaCliente != null) {
						for (Cliente c : listaCliente) {
				%>
				<tr id="linhas">
					<td><%=c.getIdCliente()%></td>
					<td><%=c.getLogin()%></td>
					<%--  <td><%= c.getTelefone() %></td>
                    <td><%= c.getEndereco() %></td> --%>
					<%-- <td><a href="ControleCliente?acao=excluir&id=<%= c.getIdCliente() %>"><img src="src/img/excluir.png" alt=""/></a><a href="ControleCliente?acao=alterar&id=<%= c.getIdCliente() %>"><img src="src/img/editar.png" alt=""/></a></td> --%>
					<td><a href="cliente?acao=buscarCli&id=<%=c.getPessoa()%>"><button
								type="button" title="Editar" id="myBtn" class="btn btn-default">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"
									style="font-size: 13px;"> </span>
							</button></a></td>
					<td><a
						href="cliente?acao=desativarCli&login=<%=c.getLogin()%>"><button
								type="button" title="Desativar" id="myBtn"
								class="btn btn-default">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"
									style="font-size: 13px;"> </span>
							</button></a></td>
				</tr>
				<%
					}
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
