package br.com.umc.marcenaria.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.umc.marcenaria.dao.EmailDao;
import br.com.umc.marcenaria.dao.impl.EmailDaoImpl;
import br.com.umc.marcenaria.modelo.Pessoa;
import br.com.umc.marcenaria.modelo.Email;

@WebServlet(urlPatterns = "/email")
public class EmailControle extends HttpServlet {

	EmailDao dao = new EmailDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response, Pessoa pessoa)
			throws ServletException, IOException {

		String emailPessoal = request.getParameter("email");
		if (emailPessoal != null) {

			Email email = new Email(null, emailPessoal, pessoa.getId());

			dao.cadastrarEmail(email, pessoa);
		}

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Pessoa pessoa = new Pessoa();
		pessoa.setId(1);
		dao.listarEmailPorPessoa(pessoa).forEach(System.out::println);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Pessoa pessoa = (Pessoa) req.getSession().getAttribute("pessoa");

		Email email = null;
		String emailPessoal = req.getParameter("email");
		if (emailPessoal != null) {

			email = new Email(null, emailPessoal, pessoa.getId());

			dao.alterarEmail(email);
		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		Email obj = new Email(null, email, null);

		dao.deletarEmail(obj);
	}

}
