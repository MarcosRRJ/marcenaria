package br.com.umc.marcenaria.dao;

import java.util.List;

import br.com.umc.marcenaria.modelo.Documento;
import br.com.umc.marcenaria.modelo.Pessoa;

public interface DocumentoDao {

	void cadastrarDocumento(Documento documento, Pessoa pessoa);

	List<Documento> listarDocumentoPorPessoa(Pessoa pessoa);

	Documento pegarUmDocumento(String login);

	void alterarDocumento(List<Documento> documentos, Pessoa pessoa);

	void deleterDocumento(Documento documento);

}
