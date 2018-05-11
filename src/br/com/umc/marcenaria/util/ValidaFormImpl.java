package br.com.umc.marcenaria.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidaFormImpl implements ValidaForm {


	@Override
	public boolean validaForm(HttpServletRequest req, HttpServletResponse resp) {
		
		boolean retorno = true;
		List<String> listaDeParamentos = new ArrayList<>();
		
		String nome = req.getParameter("nome");
		String dataNasc = req.getParameter("dataNasc");
		String tel = req.getParameter("tel");
		String cel = req.getParameter("cel");
		String emailPessoal = req.getParameter("email");
		String pais = req.getParameter("pais");
		String estado = req.getParameter("estado");
		String cidade = req.getParameter("cidade");
		String bairro = req.getParameter("bairro");
		String logadouro = req.getParameter("logradouro");
		String cep = req.getParameter("cep");
		String cpf = req.getParameter("cpf");
		String rg = req.getParameter("rg");
		String senha = req.getParameter("senha");
		String login = req.getParameter("email");
		String dep = req.getParameter("departamento");
		
		listaDeParamentos
			.addAll(Arrays.asList(nome,dataNasc, tel, cel, emailPessoal,pais,estado,
					cidade, bairro, logadouro, cep, cpf,rg,senha,login,dep));
		
//		listaDeParamentos.forEach(palavra -> if (palavra.) {
//			
//		});
		for (String string : listaDeParamentos) {
			if (string.isEmpty()) {
				retorno = false;
			}
		}
		
		return retorno;
	}

}
