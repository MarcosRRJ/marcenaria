package br.com.umc.marcenaria.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.umc.marcenaria.dao.TelefoneDao;
import br.com.umc.marcenaria.dao.impl.TelefoneDaoImpl;
import br.com.umc.marcenaria.modelo.Pessoa;
import br.com.umc.marcenaria.modelo.Telefone;

@WebServlet(urlPatterns = "/telefone")
public class TelefoneControle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	TelefoneDao dao = new TelefoneDaoImpl();

	public void doPost(HttpServletRequest req, HttpServletResponse response, Pessoa pessoa)
			throws ServletException, IOException {

		String tel = req.getParameter("tel");
		String descricao = "tel";
		if (tel != null) {
			Telefone telefone = new Telefone(null, tel, descricao, pessoa.getId());
			dao.cadastrarTelefone(telefone, pessoa);
		}

		String cel = req.getParameter("cel");
		descricao = "cel";
		if (cel != null) {

			Telefone telefoneCel = new Telefone(null, cel, descricao, pessoa.getId());
			dao.cadastrarTelefone(telefoneCel, pessoa);
		}

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		Pessoa pessoa = (Pessoa) request.getSession().getAttribute("pessoa");
		pessoa.setTelefones(dao.listarTelefonePorPessoa(pessoa));

		HttpSession session = request.getSession();
		session.setAttribute("pessoa", pessoa);

	}

	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		Pessoa pessoa = (Pessoa) req.getSession().getAttribute("pessoa");
		
		Telefone telefone = new Telefone();
		
		List<Telefone> listaDeTelefones = new ArrayList<>();
		
		String tel = req.getParameter("tel");
		String descricao = "tel";
		if (tel != null) {
			telefone.setDescricao(descricao);
			telefone.setNumero(tel);
			listaDeTelefones.add(telefone);
		}
		
		telefone = new Telefone();
		String cel = req.getParameter("cel");
		descricao = "cel";
		if (cel != null) {
			telefone.setDescricao(descricao);
			telefone.setNumero(cel);
			listaDeTelefones.add(telefone);
		}

		dao.alterarTelefone(listaDeTelefones,pessoa);
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String numero = req.getParameter("numero");
		Telefone telefone = new Telefone();
		telefone.setNumero(numero);

		dao.deleterTelefone(telefone);
	}

}
