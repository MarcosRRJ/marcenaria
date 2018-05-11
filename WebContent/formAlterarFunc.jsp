<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@page import="br.com.umc.marcenaria.modelo.Pessoa"%>
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
	<%
		/* Pessoa pessoa = (Pessoa) request.getAttribute("pessoa"); */
		Pessoa pessoa = (Pessoa) session.getAttribute("pessoa");
		ArrayList<Departamento> listaDepartamento = (ArrayList<Departamento>) request.getAttribute("listaDepartamento");
	%>
	
	<div
		class="container col-md-5 col-md-offset-4 col-sm-offset-1 col-xs-offset-1">
		<h1>Formulário de Alteração</h1>
		<hr />
		<form action="/marcenaria/funcionario" method="POST" id="form1">
			<input required="required" type="hidden" name="acao" value="alterar"> <input required="required"="required="required""
				type="hidden" name="id" value="${pessoa.id}">
			<div class="form-group">
				<div class="form-group col-md-12">
					<label for="nome">Nome Completo</label> <input required="required"type="text"
						class="form-control" id="nome" name="nome"
						value="${pessoa.nome}">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="cpf">CPF</label> <input required="required"type="text"
						class="form-control" id="cpf" name="cpf"
						value="${pessoa.documentos.get(0).numero}">
				</div>
				<div class="form-group col-md-6">
					<label for="rg">RG</label> <input required="required"type="text" class="form-control"
						id="rg" name="rg"
						value="${pessoa.documentos.get(1).numero}">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="dataNasc">Data de Nascimento</label> <input required="required"type="date"
						class="form-control" id="dataNasc" name="dataNasc"
						value="${pessoa.dataNasc}">
				</div>
				<div class="form-group col-md-4">
					<label for="pais">Nacionalidade</label> <input required="required"type="text"
						class="form-control" id="pais" name="pais"
						value="${pessoa.endereco.pais}">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-4">
					<label for="cep">Cep</label> <input required="required"type="text"
						class="form-control" id="cep" name="cep"
						value="${pessoa.endereco.cep}">
				</div>
				<div class="form-group col-md-4">
					<label for="complemento">Complemento</label> <input required="required"type="text"
						class="form-control" id="complemento" name="complemento"
						value="${pessoa.endereco.complemento}">
				</div>
				<div class="form-group col-md-4">
					<label for="bairro">Bairro</label> <input required="required"type="text"
						class="form-control" id="bairro" name="bairro"
						value="${pessoa.endereco.bairro}">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-12">
					<label for="logradouro">Logradouro</label> <input required="required"type="text"
						class="form-control" id="logradouro" name="logradouro"
						value="${pessoa.endereco.logadouro}">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="cidade">Cidade</label> <input required="required"type="text"
						class="form-control" id="cidade" name="cidade"
						value="${pessoa.endereco.cidade}">
				</div>
				<div class="form-group col-md-6">
					<label for="estado">Estado</label> <input required="required"type="text"
						class="form-control" id="estado" name="estado"
						value="${pessoa.endereco.estado}">
				</div>
			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="tel">Telefone</label> <input required="required"type="text"
						class="form-control" id="tel" name="tel"
							value="${pessoa.telefones.get(0).numero}">
				</div>
				<div class="form-group col-md-6">
					<label for="cel">Celular</label> <input required="required"type="text"
						class="form-control" id="cel" name="cel"
						value="${pessoa.telefones.get(1).numero}">
				</div>

			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="email">Email</label> <input required="required"type="text"
						class="form-control" id="email" name="email"
						value="${pessoa.funcionario.login}">
				</div>
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
					<button type="submit" name="acao" value="alterar" form="form1" 
						class="btn btn-success">Enviar</button>
				</div>
			</div>
		</form>
	</div>

<!-- 	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			Modal content
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<p>Some text in the modal.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div> -->

</body>


</html>
