package br.com.umc.marcenaria.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.umc.marcenaria.dao.FuncionarioDao;
import br.com.umc.marcenaria.dao.impl.FuncionarioDaoImpl;
import br.com.umc.marcenaria.modelo.Funcionario;
import br.com.umc.marcenaria.modelo.Perfil;
import br.com.umc.marcenaria.modelo.Pessoa;

@WebServlet(urlPatterns = "/funcionario")
public class FuncionarioControle extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TelefoneControle telefoneControle = new TelefoneControle();
	private EmailControle emailControle = new EmailControle();
	private EnderecoControle enderecoControle = new EnderecoControle();
	private DocumentoControle documentoControle = new DocumentoControle();
	private PessoaControlle pessoaControlle = new PessoaControlle();
	private DepartamentoControle departamentoControlle = new DepartamentoControle();

	private FuncionarioDao dao = new FuncionarioDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String acao = req.getParameter("acao");

		if (acao == null) {

			List<Funcionario> funcionarios = new ArrayList<>();

			funcionarios.addAll(dao.listarTodosFuncionarios());

			funcionarios.forEach(System.out::println);

			req.setAttribute("listaFuncionarios", funcionarios);
			RequestDispatcher rd = req.getRequestDispatcher("listaFuncionarios.jsp");
			rd.forward(req, resp);
		}

		if (acao != null) {
			if (acao.equals("buscarFunc")) {

				Integer id = Integer.parseInt(req.getParameter("id"));
				Funcionario funcionario = new Funcionario();

				funcionario = dao.listarUmFuncionario(id);
				Pessoa pessoa = new Pessoa();
				pessoa.setId(id);

				HttpSession session = req.getSession();
				session.setAttribute("pessoa", pessoa);

				telefoneControle.doGet(req, resp);
				pessoaControlle.doGet(req, resp);
				documentoControle.doGet(req, resp);
				enderecoControle.doGet(req, resp);
				departamentoControlle.doGet(req, resp);
				
				pessoa.setFuncionario(funcionario);

				System.out.println(pessoa);
				session.setAttribute("pessoa", pessoa);

				RequestDispatcher rd = req.getRequestDispatcher("formAlterarFunc.jsp");
				rd.forward(req, resp);
			}
			if (acao.equals("desativarFunc")) {
				doDelete(req, resp);
			}
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String acao = req.getParameter("acao");

		if (acao == null) {

			Pessoa pessoa = new Pessoa();

			pessoa.setId(pessoaControlle.doPosts(req, resp));

			telefoneControle.doPost(req, resp, pessoa);

			emailControle.doPost(req, resp, pessoa);

			enderecoControle.doPost(req, resp, pessoa);

			documentoControle.doPost(req, resp, pessoa);

			Perfil perfil = new Perfil();
			perfil.setIdPerfil(2);

			String senha = req.getParameter("senha");
			String login = req.getParameter("email");
			acao = "buscaDepart";
			
			HttpSession session = req.getSession();

			Funcionario funcionario  = new Funcionario(null, login, senha, acao, null, new Date(),null, pessoa.getId(), perfil);
			
			session.setAttribute("funcionario", funcionario);
			
			departamentoControlle.doGet(req, resp);
			funcionario.setStatus("Ativo");
			pessoa.setFuncionario(dao.cadastrarFuncionario(funcionario, perfil, pessoa, funcionario.getDepartamento()));

			// encaminha o request para o JSP
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);

		}
		if (acao.equals("alterar")) {
			doPut(req, resp);
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Pessoa pessoa = new Pessoa();
		Integer id = Integer.parseInt(req.getParameter("id"));
		pessoa.setId(id);
		
		pessoa = pessoaControlle.doPut(req, resp, pessoa);
		
		HttpSession session = req.getSession();
		session.setAttribute("pessoa", pessoa);

		telefoneControle.doGet(req, resp);
		telefoneControle.doPut(req, resp);
		
		documentoControle.doGet(req, resp);
		documentoControle.doPut(req, resp);
		
		emailControle.doPut(req, resp);
		enderecoControle.doPut(req, resp);
		
		String login = req.getParameter("email");
		Funcionario funcionario = new Funcionario(null, login, null, null, null, new Date(),null, pessoa.getId(), null);
		dao.alterarFuncionario(funcionario);
		
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios.addAll(dao.listarTodosFuncionarios());
		req.setAttribute("listaFuncionario", funcionarios);
		RequestDispatcher rd = req.getRequestDispatcher("listaFuncionarios.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		dao.deleterFuncionario(id);
		
	}

}
