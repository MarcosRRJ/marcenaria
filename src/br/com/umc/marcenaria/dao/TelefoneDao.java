package br.com.umc.marcenaria.dao;

import java.util.List;

import br.com.umc.marcenaria.modelo.Pessoa;
import br.com.umc.marcenaria.modelo.Telefone;

public interface TelefoneDao {

	void cadastrarTelefone(Telefone telefone, Pessoa pessoa);

	List<Telefone> listarTelefonePorPessoa(Pessoa pessoa);

	void alterarTelefone(Telefone telefone);

	void deleterTelefone(Telefone idTelefone);

}
