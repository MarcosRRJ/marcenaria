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

import br.com.umc.marcenaria.dao.DocumentoDao;
import br.com.umc.marcenaria.dao.impl.DocumentoDaoImpl;
import br.com.umc.marcenaria.modelo.Documento;
import br.com.umc.marcenaria.modelo.Pessoa;

@WebServlet(urlPatterns = "/documento")
public class DocumentoControle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	DocumentoDao dao = new DocumentoDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Pessoa pessoa = (Pessoa) req.getSession().getAttribute("pessoa");
		pessoa.setDocumentos(dao.listarDocumentoPorPessoa(pessoa));

		HttpSession session = req.getSession();
		session.setAttribute("pessoa", pessoa);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp, Pessoa pessoa)
			throws ServletException, IOException {

		// cadastrar documento cpf
		String cpf = req.getParameter("cpf");
		String descricaoDoc = "cpf";

		if (cpf != null) {
			Documento documentoCpf = new Documento(null, cpf, descricaoDoc, pessoa.getId());
			dao.cadastrarDocumento(documentoCpf, pessoa);
		}

		// cadastrar documento rg
		String rg = req.getParameter("rg");
		String descricaoDocRg = "rg";
		if (rg != null) {
			Documento documentoRg = new Documento(null, rg, descricaoDocRg, pessoa.getId());
			dao.cadastrarDocumento(documentoRg, pessoa);
		}

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Pessoa pessoa = (Pessoa) req.getSession().getAttribute("pessoa");
		
		List<Documento> listaDeDocumento = new ArrayList<>();
				
		// cadastrar documento cpf
		String cpf = req.getParameter("cpf");
		String descricaoDoc = "cpf";
		Documento documento;
		if (cpf != null) {
			documento = new Documento(null, cpf, descricaoDoc, pessoa.getId());
			listaDeDocumento.add(documento);
		}

		// cadastrar documento rg
		String rg = req.getParameter("rg");
		String descricaoDocRg = "rg";
		if (rg != null) {
			documento = new Documento(null, rg, descricaoDocRg, pessoa.getId());
			listaDeDocumento.add(documento);
		}

		dao.alterarDocumento(listaDeDocumento, pessoa);
	}

}
