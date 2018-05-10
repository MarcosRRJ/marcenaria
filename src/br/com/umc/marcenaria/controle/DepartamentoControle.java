package br.com.umc.marcenaria.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.umc.marcenaria.dao.DepartamentoDao;
import br.com.umc.marcenaria.dao.impl.DepartamentoDaoImpl;
import br.com.umc.marcenaria.modelo.Departamento;
import br.com.umc.marcenaria.modelo.Funcionario;

@WebServlet(urlPatterns = "/departamento")
public class DepartamentoControle extends HttpServlet {

	private static final long serialVersionUID = 1L;

	DepartamentoDao dao = new DepartamentoDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Funcionario funcionario = (Funcionario) req.getSession().getAttribute("funcionario");

		String acao = req.getParameter("acao");
		req.setAttribute("listaDepartamento", dao.listarDepartamento());
		if (acao != null && acao.equals("cadastrar")) {

			RequestDispatcher rd = req.getRequestDispatcher("formCadastroFuncionario.jsp");
			rd.forward(req, resp);

		} else if (funcionario != null && funcionario.getStatus().equals("buscaDepart")) {

			Integer numeroDeSerie = Integer.parseInt(req.getParameter("numeroDeSerie"));
			Departamento departamento = dao.pegarUmDepartamento(numeroDeSerie);
			
			funcionario.setDepartamento(departamento);

			session.setAttribute("funcionario", funcionario);

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String descricao = req.getParameter("descricao");

		Departamento departamento = new Departamento(null, null, descricao);

		dao.cadastrarDepartamento(departamento);

	}

}
