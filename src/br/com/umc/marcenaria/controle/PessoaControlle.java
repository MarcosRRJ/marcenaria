package br.com.umc.marcenaria.controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.umc.marcenaria.dao.PessoaDao;
import br.com.umc.marcenaria.dao.impl.PessoaDaoImpl;
import br.com.umc.marcenaria.modelo.Pessoa;

public class PessoaControlle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private PessoaDao dao = new PessoaDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		Pessoa pessoa = (Pessoa) req.getSession().getAttribute("pessoa");
		
		Pessoa pessoaBanco = dao.pegarUmaPessoa(pessoa.getId());
		
		pessoa.setNome(pessoaBanco.getNome());
		pessoa.setDataNasc(pessoaBanco.getDataNasc());
		
		HttpSession session = req.getSession();
		session.setAttribute("pessoa", pessoa);
	}
	
	protected Integer doPosts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date data = null;
		String nome = req.getParameter("nome");
		String dataNasc = req.getParameter("dataNasc");

		try {
			data = formato.parse(dataNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setDataNasc(data);
		
		return dao.cadastrarPessoa(pessoa); 
		
	}
	
	protected Pessoa doPut(HttpServletRequest req, HttpServletResponse resp, Pessoa pessoa) throws ServletException, IOException {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date data = null;
		String nome = req.getParameter("nome");
		String dataNasc = req.getParameter("dataNasc");

		try {
			data = formato.parse(dataNasc);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		pessoa.setNome(nome);
		pessoa.setDataNasc(data);
		
		dao.alterarPessoa(pessoa);
		
		return pessoa;
	}
}