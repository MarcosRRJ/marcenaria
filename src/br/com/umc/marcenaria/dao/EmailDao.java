package br.com.umc.marcenaria.dao;

import java.util.List;

import br.com.umc.marcenaria.modelo.Email;
import br.com.umc.marcenaria.modelo.Pessoa;

public interface EmailDao {

	void cadastrarEmail(Email email, Pessoa pessoa);

	List<Email> listarEmailPorPessoa(Pessoa pessoa);

	Email pegarUmEmail(String login);

	void alterarEmail(Email email);

	void deleterEmail(Email email);

}
