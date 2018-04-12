package br.com.umc.marcenaria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.umc.marcenaria.config.ConexaoBancoDeDados;
import br.com.umc.marcenaria.dao.EnderecoDao;
import br.com.umc.marcenaria.modelo.Pessoa;
import br.com.umc.marcenaria.modelo.Endereco;

public class EnderecoDaoImpl implements EnderecoDao {

	private Connection con = new ConexaoBancoDeDados().getConnection();

	@Override
	public void cadastrarEndereco(Endereco endereco, Pessoa pessoa) {
		try {
			String sqlInsert = "INSERT INTO Endereco(id_endereco, pais, estado, cidade, bairro, logarouro, cep, complemento, id_pessoa) "
					+ " VALUES(teledone_seq.nextval, ?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, endereco.getPais());
			ps.setString(2, endereco.getEstado());
			ps.setString(3, endereco.getCidade());
			ps.setString(4, endereco.getBairro());
			ps.setString(5, endereco.getLogadouro());
			ps.setString(6, endereco.getCep());
			ps.setString(7, endereco.getComplemento());
			ps.setInt(8, pessoa.getId());

			ps.execute();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Endereco> listarEnderecoPorPessoa(Pessoa pessoa) {

		try {
			List<Endereco> enderecos = new ArrayList<>();

			String sqlSelect = "SELECT * FROM Endereco where id_pessoa = ?";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, pessoa.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setIdEndereco(rs.getInt("id_endereco"));
				endereco.setPais(rs.getString("pais"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setLogadouro(rs.getString("logarouro"));
				endereco.setCep(rs.getString("cep"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setIdPessoa(pessoa.getId());

				enderecos.add(endereco);
			}
			return enderecos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterarEndereco(Endereco endereco) {

		try {

			String sqlUpdate = "UPDATE Endereco SET pais =?, estado=?, cidade=?, bairro=?, logadouro=?, cep=? complemento=? WHERE id_endereco = ?";

			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, endereco.getPais());
			ps.setString(2, endereco.getEstado());
			ps.setString(3, endereco.getCidade());
			ps.setString(4, endereco.getBairro());
			ps.setString(5, endereco.getLogadouro());
			ps.setString(6, endereco.getCep());
			ps.setString(7, endereco.getComplemento());
			ps.setInt(8, endereco.getIdEndereco());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleterEndereco(Endereco endereco) {
		try {
			String sqlUpdate = "DELETE FROM Endereco id_endereco = ?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setInt(1, endereco.getIdEndereco());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Endereco listarUmEndereco(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
