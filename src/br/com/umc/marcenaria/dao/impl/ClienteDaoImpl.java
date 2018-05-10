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
import br.com.umc.marcenaria.modelo.Pessoa;

public class ClienteDaoImpl implements ClienteDao {

	

	@Override
	public Cliente cadastrarCliente(Cliente cliente, Perfil perfil, Pessoa pesssoa) {
		Connection con = new ConexaoBancoDeDados().getConnection();
		Cliente obj = new Cliente();
		String generatedColumns[] = { "id_cliente" };
		try {
			String sqlInsert = "INSERT INTO CLIENTE(id_cliente, login,senha,data_cadastro,id_perfil, id_pessoa, status) VALUES(CLIENTE_seq.nextval, ?, ?, ?, ?, ?,  'Ativo')";
			PreparedStatement ps = con.prepareStatement(sqlInsert, generatedColumns);
			ps.setString(1, cliente.getLogin());
			ps.setString(2, cliente.getSenha());
			ps.setDate(3, new Date(System.currentTimeMillis()));
			ps.setInt(4, perfil.getIdPerfil());
			ps.setInt(5, pesssoa.getId());
			ps.execute();
			
			try (ResultSet rs = ps.getGeneratedKeys()) {

				if (rs.next()) {
					obj = listarUmCliente(rs.getInt(1));
				}

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public List<Cliente> listarTodosClientes() {
		
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			List<Cliente> clientes = new ArrayList<>();

			String sqlSelect = "SELECT * FROM CLIENTE c, Perfil per "
					+ "where c.id_perfil = per.id_perfil and status = 'Ativo'";
			PreparedStatement ps = con.prepareStatement(sqlSelect);			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				Perfil perfil = new Perfil();
				cliente.setIdCliente(rs.getInt("id_cliente"));
				cliente.setLogin(rs.getString("login"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setDataCadastro(rs.getDate("data_cadastro"));
				cliente.setStatus(rs.getString("status"));
				cliente.setPessoa(rs.getInt("id_pessoa"));
				perfil.setIdPerfil(rs.getInt("id_perfil"));
				perfil.setDescricao(rs.getString("descricao"));
				cliente.setPerfil(perfil);
				System.out.println(cliente);
				
				clientes.add(cliente);
			}

			ps.close();
			con.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Cliente listarUmCliente(Integer login) {
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			Cliente cliente = new Cliente();

			String sqlSelect = "SELECT * FROM CLIENTE c, Perfil per WHERE c.id_pessoa = ? "
							+ " and c.id_perfil = per.id_perfil ";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, login);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Perfil perfil = new Perfil();
				cliente.setIdCliente(rs.getInt("id_cliente"));
				cliente.setLogin(rs.getString("login"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setDataCadastro(rs.getDate("data_cadastro"));
				cliente.setStatus(rs.getString("status"));
				cliente.setPessoa(rs.getInt("id_pessoa"));
				perfil.setIdPerfil(rs.getInt("id_perfil"));
				perfil.setDescricao(rs.getString("descricao"));
				cliente.setPerfil(perfil);
			}

			ps.close();
			con.close();
			return cliente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterarCliente(Cliente cliente) {
		
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			String sqlUpdate = "UPDATE CLIENTE SET login =? WHERE id_pessoa =?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, cliente.getLogin());
			ps.setInt(2, cliente.getPessoa());
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
			Connection con = new ConexaoBancoDeDados().getConnection();
			String sqlInsert = "UPDATE CLIENTE set status = 'Inativo' where login LIKE ?  ";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, login);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
