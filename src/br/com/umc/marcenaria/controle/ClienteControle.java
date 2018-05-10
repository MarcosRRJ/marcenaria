package br.com.umc.marcenaria.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.umc.marcenaria.dao.ClienteDao;
import br.com.umc.marcenaria.dao.impl.ClienteDaoImpl;
import br.com.umc.marcenaria.modelo.Cliente;
import br.com.umc.marcenaria.modelo.Perfil;
import br.com.umc.marcenaria.modelo.Pessoa;

@WebServlet(urlPatterns = "/cliente")
public class ClienteControle extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TelefoneControle telefoneControle = new TelefoneControle();
	private EmailControle emailControle = new EmailControle();
	private EnderecoControle enderecoControle = new EnderecoControle();
	private DocumentoControle documentoControle = new DocumentoControle();
	private PessoaControlle pessoaControlle = new PessoaControlle();

	private ClienteDao dao = new ClienteDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String acao = req.getParameter("acao");

		if (acao == null) {

			List<Cliente> clientes = new ArrayList<>();

			clientes.addAll(dao.listarTodosClientes());

			clientes.forEach(System.out::println);

			req.setAttribute("listaCliente", clientes);
			RequestDispatcher rd = req.getRequestDispatcher("listaClientes.jsp");
			rd.forward(req, resp);
		}

		if (acao != null) {
			if (acao.equals("buscarCli")) {

				Integer id = Integer.parseInt(req.getParameter("id"));
				Cliente cliente = new Cliente();

				cliente = dao.listarUmCliente(id);
				Pessoa pessoa = new Pessoa();
				pessoa.setId(id);

				HttpSession session = req.getSession();
				session.setAttribute("pessoa", pessoa);

				telefoneControle.doGet(req, resp);
				pessoaControlle.doGet(req, resp);
				documentoControle.doGet(req, resp);
				enderecoControle.doGet(req, resp);

				pessoa.setCliente(cliente);

				System.out.println(pessoa);
				session.setAttribute("pessoa", pessoa);

				RequestDispatcher rd = req.getRequestDispatcher("formAlterar.jsp");
				rd.forward(req, resp);
			}
			if (acao.equals("desativarCli")) {
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
			perfil.setIdPerfil(1);

			String senha = req.getParameter("senha");
			String login = req.getParameter("email");
			Cliente cliente = new Cliente(null, login, senha, null, null, pessoa.getId(), perfil);

			pessoa.setCliente(dao.cadastrarCliente(cliente, perfil, pessoa));

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
		Cliente cliente = new Cliente(null, login, null, null, null, pessoa.getId(), null);
		dao.alterarCliente(cliente);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.addAll(dao.listarTodosClientes());
		req.setAttribute("listaCliente", clientes);
		RequestDispatcher rd = req.getRequestDispatcher("listaClientes.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		dao.deleterCliente(login);
		
	}

}
