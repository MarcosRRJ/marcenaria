package br.com.umc.marcenaria.dao;

import br.com.umc.marcenaria.modelo.Endereco;
import br.com.umc.marcenaria.modelo.Pessoa;

public interface EnderecoDao {

	void cadastrarEndereco(Endereco endereco, Pessoa pessoa);

	Endereco listarEnderecoPorPessoa(Pessoa pessoa);

	Endereco listarUmEndereco(Pessoa login);

	void alterarEndereco(Endereco endereco);

	void deleterEndereco(Endereco endereco);

}
