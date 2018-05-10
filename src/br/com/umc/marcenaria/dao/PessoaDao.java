package br.com.umc.marcenaria.dao;

import br.com.umc.marcenaria.modelo.Pessoa;

public interface PessoaDao {

	Integer cadastrarPessoa(Pessoa pessoa);

//	List<Pessoa> listarTodasPessoas();

	Pessoa pegarUmaPessoa(Integer id);

	void alterarPessoa(Pessoa pessoa);

	void deleterPessoa(Pessoa email);

}
