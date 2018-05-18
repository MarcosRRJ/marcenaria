package br.com.umc.marcenaria.controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.umc.marcenaria.dao.ClienteDao;
import br.com.umc.marcenaria.dao.impl.ClienteDaoImpl;
import br.com.umc.marcenaria.modelo.Cliente;

@WebServlet(urlPatterns = "/login")
public class LoginControle extends HttpServlet {

	ClienteDao dao = new ClienteDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		if ((login == null || senha == null) || (login.isEmpty() || senha.isEmpty())) {
			out.println(login == null ? "<p>Campo login obrigatório</p>" : "<p>Campo senha obrigatório</p>");
			// out.println("<p>Login ou senha inválido</p>");
			return;
		}
		Cliente cliente = dao.efetuarLogin(login, senha);
		if (cliente.getStatus().equals("Inativo")) {
			out.println("<p>Usuário inativo</p>");
		}
	}

}
