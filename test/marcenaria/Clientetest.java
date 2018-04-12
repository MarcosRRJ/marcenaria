package marcenaria;

import java.util.Date;

import br.com.umc.marcenaria.dao.ClienteDao;
import br.com.umc.marcenaria.dao.impl.ClienteDaoImpl;
import br.com.umc.marcenaria.modelo.Cliente;
import br.com.umc.marcenaria.modelo.Perfil;

public class Clientetest {

	public static void main(String[] args) {
		Clientetest clientetest = new Clientetest();

		Cliente cliente = new Cliente();
		cliente.setIdCliente(2);
		cliente.setNome("Marcos");
		cliente.setDataNasc(new Date());
		cliente.setLogin("marcos");
		cliente.setSenha("1");

		Perfil perfil = new Perfil();
		perfil.setIdPerfil(1);

		clientetest.inserirCliente(cliente, perfil);
		clientetest.consultarCliente();
		clientetest.alterarClientePorEmail(cliente, perfil);
		System.out.println("Por login");
		clientetest.deletarClientePorEmail("marcos");
		clientetest.consultarClientePorEmail("marcosrrj2@gmail.com");
	}

	private void inserirCliente(Cliente cliente, Perfil perfil) {
		ClienteDao dao = new ClienteDaoImpl();
		dao.cadastrarCliente(cliente, perfil);

	}

	private void consultarCliente() {
		ClienteDao dao = new ClienteDaoImpl();
		dao.listarTodosClientes();

	}

	private void consultarClientePorEmail(String login) {
		ClienteDao dao = new ClienteDaoImpl();
		dao.listarUmCliente(login);

	}

	private void alterarClientePorEmail(Cliente cliente, Perfil perfil) {
		ClienteDao dao = new ClienteDaoImpl();
		dao.alterarCliente(cliente, perfil);

	}

	private void deletarClientePorEmail(String login) {
		ClienteDao dao = new ClienteDaoImpl();
		dao.deleterCliente(login);

	}
}
