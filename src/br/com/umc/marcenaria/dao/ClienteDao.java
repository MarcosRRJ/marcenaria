package br.com.umc.marcenaria.dao;

import java.util.List;

import br.com.umc.marcenaria.modelo.Cliente;
import br.com.umc.marcenaria.modelo.Perfil;

public interface ClienteDao {

	void cadastrarCliente(Cliente cliente, Perfil perfil);

	List<Cliente> listarTodosClientes();

	Cliente listarUmCliente(String login);

	void alterarCliente(Cliente cliente, Perfil perfil);

	void deleterCliente(String login);

}
