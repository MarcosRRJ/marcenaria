<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; utf-8">
		<title>Insert title here</title>
		<!-- Latest compiled and minified CSS -->
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div class="container col-md-5 col-md-offset-4 col-sm-offset-1 col-xs-offset-1">


			<h1>Formulário de Cadastro</h1>
			<hr />
			<%-- <form action="/marcenaria/cliente" method="post" id="form1"> --%>
			<form method="post" id="form1">
			  <div class="form-group">
					<div class="form-group col-md-12">
				    <label for="nome">Nome Completo</label>
				    <input required="required" type="text" class="form-control" id="nome"  name="nome" placeholder="Maria José">
							<p style="display: none;color:red;" id="1">Campo obrigatório</p>
					</div>
			  </div>
				<div class="form-group">
					<div class="form-group col-md-6">
						<label for="cpf">CPF</label>
						<input required="required" type="text" class="form-control" id="cpf"  name="cpf">
						<p style="display: none;color:red;" id="12">Campo obrigatório</p>
					</div>
					<div class="form-group col-md-6">
						<label for="rg">RG</label>
						<input required="required" type="text" class="form-control" id="rg"  name="rg">
						<p style="display: none;color:red;" id="13">Campo obrigatório</p>
					</div>
				</div>
			  <div class="form-group">
					<div class="form-group col-md-6">
						<label for="dataNasc">Data de Nascimento</label>
				    <input required="required" type="text" class="form-control" id="dataNasc"  name="dataNasc" placeholder="">
						<p style="display: none;color:red;" id="2">Campo obrigatório</p>
					</div>
					<div class="form-group col-md-4">
				      <label for="pais" >Nacionalidade</label>
				      <input required="required" type="text" class="form-control" id="pais"  name="pais">
							<p style="display: none;color:red;" id="6">Campo obrigatório</p>
				    </div>
			  </div>
				<div class="form-group">
					<div class="form-group col-md-4">
						<label for="cep">Cep</label>
						<input required="required" type="text" class="form-control" id="cep"  name="cep">
						<p style="display: none;color:red;" id="11">Campo obrigatório</p>
					</div>
					<div class="form-group col-md-4">
						<label for="complemento">Complemento</label>
						<input required="required" type="text" class="form-control" id="complemento"  name="complemento">
					</div>
					<div class="form-group col-md-4">
						<label for="bairro" >Bairro</label>
						<input required="required" type="text" class="form-control" id="bairro"  name="bairro">
						<p style="display: none;color:red;" id="9">Campo obrigatório</p>
					</div>
				</div>
				<div class="form-group">
					<div class="form-group col-md-12">
						<label for="logradouro">Logradouro</label>
						<input required="required" type="text" class="form-control" id="logradouro"  name="logradouro" placeholder="">
						<p style="display: none;color:red;" id="10">Campo obrigatório</p>
					</div>
				</div>
			  <div class="form-group">
			    <div class="form-group col-md-6">
			      <label for="cidade">Cidade</label>
			      <input required="required" type="text" class="form-control" id="cidade"  name="cidade">
						<p style="display: none;color:red;" id="8">Campo obrigatório</p>
			    </div>
			    <div class="form-group col-md-6">
			      <label for="estado">Estado</label>
						<input required="required" type="text" class="form-control" id="estado"  name="estado">
						<p style="display: none;color:red;" id="7">Campo obrigatório</p>
			    </div>
			  </div>
				<div class="form-group">
					<div class="form-group col-md-6">
						<label for="tel">Telefone</label>
						<input required="required" type="text" class="form-control" id="tel"  name="tel" placeholder="(DDD)">
						<p style="display: none;color:red;" id="3">Campo obrigatório</p>
					</div>
					<div class="form-group col-md-6">
						<label for="cel">Celular</label>
						<input required="required" type="text" class="form-control" id="cel"  name="cel" placeholder="(DDD)">
						<p style="display: none;color:red;" id="4">Campo obrigatório</p>
					</div>
				</div>
				<div class="form-group">
					<div class="form-group col-md-12">
				    <label for="email">Email</label>
				    <input required="required" type="text" class="form-control" id="email"  name="email" placeholder="">
						<p style="display: none;color:red;" id="15">Campo obrigatório</p>
					</div>
			  </div>
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="senha">Senha</label>
						<input required="required" type="password" class="form-control" id="senha"  name="senha" placeholder="Password">
						<p style="display: none;color:red;" id="14">Campo obrigatório</p>
					</div>
				</div>
				<div class="form-group">
					<div class="form-group col-md-12 col-md-offset-6 col-sm-offset-6 col-xs-offset-6">
					 <input type="submit"  id="cadCli" value="Enviar" class="btn btn-success"></input>
				  <!--  <button type="submit" form="form1"  value="Submit" class="btn btn-success">Enviar</button> -->
					</div>
			  </div>
			</form>

			<div class="modal fade" id="myModal" role="dialog">
		    	<div class="modal-dialog">

			      <!-- Modal content-->
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
  			</div>

		</div>
		<!-- <script src="src/js/jquery/jquery.min.js"></script> -->
		 <script src="https://cdnjs.cloudflare.com/ajax/libs/bluebird/3.3.4/bluebird.min.js"></script>
  		 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  		 <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
			 <script src="https://igorescobar.github.io/jQuery-Mask-Plugin/js/jquery.mask.min.js"></script>
  		 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<script src="src/js/controle.js" ></script>
	</body>
</html>
