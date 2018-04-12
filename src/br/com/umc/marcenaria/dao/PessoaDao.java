package br.com.umc.marcenaria.dao;

import br.com.umc.marcenaria.modelo.Pessoa;

public interface PessoaDao {

	void cadastrarPessoa(Pessoa pessoa);

//	List<Pessoa> listarTodasPessoas();

//	Pessoa pegarUmaPessoa(String login);

	void alterarPessoa(Pessoa pessoa);

	void deleterPessoa(Pessoa email);

}
