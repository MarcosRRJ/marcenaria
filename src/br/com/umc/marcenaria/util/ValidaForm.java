package br.com.umc.marcenaria.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ValidaForm {
	
	boolean validaForm(HttpServletRequest req, HttpServletResponse resp);

}
