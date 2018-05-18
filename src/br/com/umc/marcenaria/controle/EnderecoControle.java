package br.com.umc.marcenaria.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.umc.marcenaria.dao.EnderecoDao;
import br.com.umc.marcenaria.dao.impl.EnderecoDaoImpl;
import br.com.umc.marcenaria.modelo.Endereco;
import br.com.umc.marcenaria.modelo.Pessoa;

@WebServlet(urlPatterns = "/endereco")
public class EnderecoControle extends HttpServlet {

	private static final long serialVersionUID = 1L;

	EnderecoDao dao = new EnderecoDaoImpl();

	public void doPost(HttpServletRequest req, HttpServletResponse response, Pessoa pessoa)
			throws ServletException, IOException {

		// cadastrar endereco
		String pais = req.getParameter("pais");
		String estado = req.getParameter("estado");
		String cidade = req.getParameter("cidade");
		String bairro = req.getParameter("bairro");
		String logadouro = req.getParameter("logradouro");
		String cep = req.getParameter("cep");
		String complemento = (req.getParameter("complemento") == null || req.getParameter("complemento").isEmpty()
				? "vazio" : req.getParameter("complemento"));

		Endereco endereco = new Endereco(null, pais, estado, cidade, bairro, logadouro, cep, complemento,
				pessoa.getId());

		dao.cadastrarEndereco(endereco, pessoa);

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Pessoa pessoa = (Pessoa) request.getSession().getAttribute("pessoa");

		pessoa.setEndereco(dao.listarEnderecoPorPessoa(pessoa));
		HttpSession session = request.getSession();
		session.setAttribute("pessoa", pessoa);
	}

	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Pessoa pessoa = (Pessoa) req.getSession().getAttribute("pessoa");

		// cadastrar endereco
		String pais = req.getParameter("pais");
		String estado = req.getParameter("estado");
		String cidade = req.getParameter("cidade");
		String bairro = req.getParameter("bairro");
		String logadouro = req.getParameter("logradouro");
		String cep = req.getParameter("cep");
		String complemento = (req.getParameter("complemento") == null || req.getParameter("complemento").isEmpty()
				? "vazio" : req.getParameter("complemento"));

		Endereco endereco = new Endereco(null, pais, estado, cidade, bairro, logadouro, cep, complemento,
				pessoa.getId());
		
		 dao.alterarEndereco(endereco);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// String numero = req.getParameter("numero");
		Endereco endereco = new Endereco();
		// endereco.setNumero(numero);

		dao.deleterEndereco(endereco);
	}

}
