package br.com.umc.marcenaria.dao;

import java.util.List;

public interface ImagemDao {

	void cadastrarDocumento(String imagem, Integer idInteger);

	List<String> listarDocumentoPorPessoa(Integer idProduto);


}
