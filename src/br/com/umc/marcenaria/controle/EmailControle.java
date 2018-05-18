package br.com.umc.marcenaria.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.umc.marcenaria.dao.EmailDao;
import br.com.umc.marcenaria.dao.ImagemDao;
import br.com.umc.marcenaria.dao.impl.EmailDaoImpl;
import br.com.umc.marcenaria.dao.impl.ImagemDaoImpl;
import br.com.umc.marcenaria.modelo.Pessoa;
import br.com.umc.marcenaria.modelo.Email;

@WebServlet(urlPatterns = "/email")
public class EmailControle extends HttpServlet {

	EmailDao dao = new EmailDaoImpl();
	ImagemDao imagemDao = new ImagemDaoImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response, Pessoa pessoa)
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

		PrintWriter out = response.getWriter();

		Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
		List<String> imgs = imagemDao.listarDocumentoPorPessoa(idProduto);

		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Arquivo gravado!</h1>");
		for (String img : imgs) {
			out.println("<img src='" + img + "' alt='Smiley face' width='42' height='42'>");
		}
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Pessoa pessoa = (Pessoa) req.getSession().getAttribute("pessoa");

		Email email = null;
		String emailPessoal = req.getParameter("email");
		if (emailPessoal != null) {

			email = new Email(null, emailPessoal, pessoa.getId());

			dao.alterarEmail(email);
		}

	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		Email obj = new Email(null, email, null);

		dao.deletarEmail(obj);
	}

}
