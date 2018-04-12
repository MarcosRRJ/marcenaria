package br.com.umc.marcenaria.dao;

import java.util.List;

import br.com.umc.marcenaria.modelo.Endereco;
import br.com.umc.marcenaria.modelo.Pessoa;

public interface EnderecoDao {

	void cadastrarEndereco(Endereco endereco, Pessoa pessoa);

	List<Endereco> listarEnderecoPorPessoa(Pessoa pessoa);

	Endereco listarUmEndereco(String login);

	void alterarEndereco(Endereco endereco);

	void deleterEndereco(Endereco endereco);

}
