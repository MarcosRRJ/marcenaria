package br.com.umc.marcenaria.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.umc.marcenaria.dao.DepartamentoDao;
import br.com.umc.marcenaria.dao.impl.DepartamentoDaoImpl;
import br.com.umc.marcenaria.modelo.Departamento;

@WebServlet(urlPatterns = "/departamento")
public class DepartamentoControle extends HttpServlet {

	private static final long serialVersionUID = 1L;

	DepartamentoDao dao = new DepartamentoDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("listaDepartamento", dao.listarDepartamento());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String descricao = req.getParameter("descricao");

		Departamento departamento = new Departamento(null, null, descricao);

		dao.cadastrarDepartamento(departamento);

	}

}
