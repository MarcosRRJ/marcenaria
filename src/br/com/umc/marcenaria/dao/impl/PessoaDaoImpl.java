package br.com.umc.marcenaria.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.umc.marcenaria.config.ConexaoBancoDeDados;
import br.com.umc.marcenaria.dao.PessoaDao;
import br.com.umc.marcenaria.modelo.Pessoa;

public class PessoaDaoImpl implements PessoaDao {

	@Override
	public Integer cadastrarPessoa(Pessoa pessoa) {
		Integer id = null;
		String generatedColumns[] = { "ID" };
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			
			String sqlInsert = "INSERT INTO Pessoa(id, nome, dataNasc) VALUES(pessoa_seq.nextval, ?,?)";
			PreparedStatement ps = con.prepareStatement(sqlInsert, generatedColumns);
			ps.setString(1, pessoa.getNome());
			ps.setDate(2,new Date(pessoa.getDataNasc().getTime()));
			ps.execute();

			try (ResultSet rs = ps.getGeneratedKeys()) {
				
			
				
				if (rs.next()) {
				System.out.println(rs.getInt(1));
				id = rs.getInt(1);

				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

//	@Override
//	public List<Pessoa> listarTodasPessoas() {
//
//		try {
//			Connection con = new ConexaoBancoDeDados().getConnection();
//			
//			List<Pessoa> pessoas = new ArrayList<>();
//
//			String sqlSelect = "SELECT * FROM Pessoa";
//			PreparedStatement ps = con.prepareStatement(sqlSelect);
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				Pessoa pessoa = new Pessoa();
//				pessoa.setId(rs.getInt("id_pessoa"));
//				pessoa.setNome(rs.getString("nome"));
//				pessoa.setDataNasc(rs.getDate("dataCadastro"));
//				pessoa.setStatus(rs.getString("status"));
//				pessoas.add(pessoa);
//			}
//			pessoas.forEach(System.out::println);
//
//			ps.close();
//			return pessoas;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}

	@Override
	public Pessoa pegarUmaPessoa(Integer id) {
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			Pessoa pessoa = new Pessoa();

			String sqlSelect = "SELECT * FROM pessoa WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setDataNasc(rs.getDate("dataNasc"));
			}

			ps.close();
			return pessoa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterarPessoa(Pessoa pessoa) {

		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			
			String sqlUpdate = "UPDATE Pessoa SET nome =? WHERE id =?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, pessoa.getNome());
			ps.setInt(2, pessoa.getId());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleterPessoa(Pessoa pessoa) {

		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			
			String sqlInsert = "UPDATE CLIENTE set status = 'D' where nome LIKE ?  ";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, pessoa.getNome());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
