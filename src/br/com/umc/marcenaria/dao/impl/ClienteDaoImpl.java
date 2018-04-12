package br.com.umc.marcenaria.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.umc.marcenaria.config.ConexaoBancoDeDados;
import br.com.umc.marcenaria.dao.ClienteDao;
import br.com.umc.marcenaria.modelo.Cliente;
import br.com.umc.marcenaria.modelo.Perfil;

public class ClienteDaoImpl implements ClienteDao {

	private Connection con = new ConexaoBancoDeDados().getConnection();

	@Override
	public void cadastrarCliente(Cliente cliente, Perfil perfil) {

		try {
			String sqlInsert = "INSERT INTO CLIENTE(idCliente, nome, dataCadastro, login,senha,perfil, status) VALUES(CLIENTE_seq.nextval, ?,?,?,?,?, 'A')";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, cliente.getNome());
			ps.setDate(2, new Date(System.currentTimeMillis()));
			ps.setString(3, cliente.getLogin());
			ps.setString(4, cliente.getSenha());
			ps.setInt(5, perfil.getIdPerfil());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Cliente> listarTodosClientes() {

		try {
			List<Cliente> clientes = new ArrayList<>();

			String sqlSelect = "SELECT * FROM CLIENTE";
			PreparedStatement ps = con.prepareStatement(sqlSelect);			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setDataNasc(rs.getDate("dataCadastro"));
				cliente.setLogin(rs.getString("login"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setStatus(rs.getString("status"));
				cliente.setPerfil(rs.getInt("perfil"));
				
				clientes.add(cliente);
			}
			clientes.forEach(System.out::println);

			ps.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Cliente listarUmCliente(String login) {
		try {
			Cliente cliente = new Cliente();

			String sqlSelect = "SELECT * FROM CLIENTE WHERE LOGIN like ?";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ps.setString(1, "%"+login+"%");
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setDataNasc(rs.getDate("dataCadastro"));
				cliente.setLogin(rs.getString("login"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setPerfil(rs.getInt("perfil"));
				System.out.println(cliente);
			}

			ps.close();
			return cliente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterarCliente(Cliente cliente, Perfil perfil) {
		
		try {
			String sqlUpdate = "UPDATE CLIENTE SET nome =?, login =?, senha =?, perfil =? WHERE idcliente =?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getLogin());
			ps.setString(3, cliente.getSenha());
			ps.setInt(4, perfil.getIdPerfil());
			ps.setInt(5, cliente.getIdCliente());
			ps.executeUpdate();
			
			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	@Override
	public void deleterCliente(String login) {
		
		try {
			String sqlInsert = "UPDATE CLIENTE set status = 'D' where login LIKE ?  ";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, login);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
