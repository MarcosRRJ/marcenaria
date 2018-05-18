package br.com.umc.marcenaria.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ValidaForm {
	
	Erro verificaErro(HttpServletRequest req, HttpServletResponse resp);

}
