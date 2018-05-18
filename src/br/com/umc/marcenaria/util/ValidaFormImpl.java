package br.com.umc.marcenaria.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidaFormImpl implements ValidaForm {

	@Override
	public Erro verificaErro(HttpServletRequest req, HttpServletResponse resp) {
		
		Erro erro = new Erro();
		
		List<String> listaDeParamentos = new ArrayList<>();

		String nome = req.getParameter("nome").isEmpty() ? "1" : req.getParameter("nome");
		String dataNasc = req.getParameter("dataNasc").isEmpty() ? "2" : req.getParameter("dataNasc");
		String tel = req.getParameter("tel").isEmpty() ? "3" : req.getParameter("tel");
		String cel = req.getParameter("cel").isEmpty() ? "4" : req.getParameter("cel");
		String emailPessoal = req.getParameter("email").isEmpty() ? "5" : req.getParameter("email");
		String pais = req.getParameter("pais").isEmpty() ? "6" : req.getParameter("pais");
		String estado = req.getParameter("estado").isEmpty() ? "7" : req.getParameter("estado");
		String cidade = req.getParameter("cidade").isEmpty() ? "8" : req.getParameter("cidade");
		String bairro = req.getParameter("bairro").isEmpty() ? "9" : req.getParameter("bairro");
		String logadouro = req.getParameter("logradouro").isEmpty() ? "10" : req.getParameter("logradouro");
		String cep = req.getParameter("cep").isEmpty() ? "11" : req.getParameter("cep");
		String cpf = req.getParameter("cpf").isEmpty() ? "12" : req.getParameter("cpf");
		String rg = req.getParameter("rg").isEmpty() ? "13" : req.getParameter("rg");
		String senha = req.getParameter("senha").isEmpty() ? "14" : req.getParameter("senha");
		String login = req.getParameter("email").isEmpty() ? "15" : req.getParameter("email");

		listaDeParamentos.addAll(Arrays.asList(nome, dataNasc, tel, cel, emailPessoal, pais, estado, cidade, bairro,
				logadouro, cep, cpf, rg, senha, login));

		for (String elemento : listaDeParamentos) {

			if (elemento == null || elemento.length() < 3) {
				erro.getErroVazio().add(elemento);
			}
		}
		
		if (cpf.length() > 2) {
			ValidadorCPF validadorCPF = new ValidadorCPF();
			validadorCPF.isValido(cpf);
			erro.setCpf("CPF inválido");
			erro.getErroDeTipo().add("cpf");
		}

		return erro;
	}

}
