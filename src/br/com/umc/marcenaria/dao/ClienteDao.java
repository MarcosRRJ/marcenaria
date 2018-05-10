package br.com.umc.marcenaria.dao;

import java.util.List;

import br.com.umc.marcenaria.modelo.Cliente;
import br.com.umc.marcenaria.modelo.Perfil;
import br.com.umc.marcenaria.modelo.Pessoa;

public interface ClienteDao {

	Cliente cadastrarCliente(Cliente cliente, Perfil perfil, Pessoa pesssoa);

	List<Cliente> listarTodosClientes();

	Cliente listarUmCliente(Integer login);

	void alterarCliente(Cliente cliente);

	void deleterCliente(String login);

}
