<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@page import="br.com.umc.marcenaria.modelo.Departamento"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
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
	<div
		class="container col-md-5 col-md-offset-4 col-sm-offset-1 col-xs-offset-1">
		<%
			ArrayList<Departamento> listaDepartamento = (ArrayList<Departamento>) request.getAttribute("listaDepartamento");
		%>

		<h1>Formulário de Cadastro</h1>
		<hr />
		<form action="/marcenaria/funcionario" method="post" id="form1">
		<p style="color: red;">${errorString}</p>
			<div class="form-group">
				<div class="form-group col-md-12">
					<label for="nome">Nome Completo</label> <input type="text"
						class="form-control" id="nome" name="nome"
						placeholder="Maria José">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="cpf">CPF</label> <input type="text"
						class="form-control" id="cpf" name="cpf" placeholder="1234567890">
				</div>
				<div class="form-group col-md-6">
					<label for="rg">RG</label> <input type="text" class="form-control"
						id="rg" name="rg">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="dataNasc">Data de Nascimento</label> <input type="date"
						class="form-control" id="dataNasc" name="dataNasc" placeholder="">
				</div>
				<div class="form-group col-md-4">
					<label for="pais">Nacionalidade</label> <input type="text"
						class="form-control" id="pais" name="pais">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-4">
					<label for="cep">Cep</label> <input type="text"
						class="form-control" id="cep" name="cep">
				</div>
				<div class="form-group col-md-4">
					<label for="complemento">Complemento</label> <input type="text"
						class="form-control" id="complemento" name="complemento">
				</div>
				<div class="form-group col-md-4">
					<label for="bairro">Bairro</label> <input type="text"
						class="form-control" id="bairro" name="bairro">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="cidade">Cidade</label> <input type="text"
						class="form-control" id="cidade" name="cidade">
				</div>
				<div class="form-group col-md-6">
					<label for="estado">Estado</label> <input type="text"
						class="form-control" id="estado" name="estado">
				</div>			
			</div>
			<div class="form-group">
				<div class="form-group col-md-12">
					<label for="logradouro">Logradouro</label> <input type="text"
						class="form-control" id="logradouro" name="logradouro"
						placeholder="">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="tel">Telefone</label> <input type="text"
						class="form-control" id="tel" name="tel" placeholder="(DDD)">
				</div>
				<div class="form-group col-md-6">
					<label for="cel">Celular</label> <input type="text"
						class="form-control" id="cel" name="cel" placeholder="(DDD)">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="email">Email</label> <input type="text"
						class="form-control" id="email" name="email" placeholder="">
				</div>
				<div class="form-group col-md-6">
					<label for="senha">Senha</label> <input type="password"
						class="form-control" id="senha" name="senha"
						placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="cidade">Departamento</label> 
						<select class="form-control" name="departamento" >
							<option selected disabled>Selecione um Departamento</option>
							<c:forEach var="item" items="${listaDepartamento}">
							  <option value="${item.idDepartamento}">${item.descricao}</option>
							</c:forEach>
						</select>
				</div>
			</div>
			<div class="form-group">
				<div
					class="form-group col-md-12 col-md-offset-6 col-sm-offset-6 col-xs-offset-6">
					<button type="submit" form="form1" value="Submit"
						class="btn btn-success">Enviar</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
