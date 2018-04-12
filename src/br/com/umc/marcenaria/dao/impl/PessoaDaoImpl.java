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
import br.com.umc.marcenaria.modelo.Perfil;

public class PessoaDaoImpl implements PessoaDao {

	private Connection con = new ConexaoBancoDeDados().getConnection();

	@Override
	public void cadastrarPessoa(Pessoa pessoa) {

		try {
			String sqlInsert = "INSERT INTO Pessoa(id_pessoa, nome, dataCadastro, status) VALUES(pessoa_seq.nextval, ?,?,'A')";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, pessoa.getNome());
			ps.setDate(2, new Date(System.currentTimeMillis()));
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	@Override
//	public List<Pessoa> listarTodasPessoas() {
//
//		try {
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

//	@Override
//	public Pessoa pegarUmaPessoa(String login) {
//		try {
//			Pessoa pessoa = new Pessoa();
//
//			String sqlSelect = "SELECT * FROM CLIENTE WHERE LOGIN like ?";
//			PreparedStatement ps = con.prepareStatement(sqlSelect);
//			ps.setString(1, "%"+login+"%");
//			
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				
//				pessoa.setIdPessoa(rs.getInt("idPessoa"));
//				pessoa.setNome(rs.getString("nome"));
//				pessoa.setDataNasc(rs.getDate("dataCadastro"));
//				pessoa.setLogin(rs.getString("login"));
//				pessoa.setSenha(rs.getString("senha"));
//				pessoa.setPerfil(rs.getInt("perfil"));
//				System.out.println(pessoa);
//			}
//
//			ps.close();
//			return pessoa;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}

	@Override
	public void alterarPessoa(Pessoa pessoa) {
		
		try {
			String sqlUpdate = "UPDATE Pessoa SET nome =? WHERE id_pessoa =?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, pessoa.getNome());
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
			String sqlInsert = "UPDATE CLIENTE set status = 'D' where nome LIKE ?  ";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, pessoa.getNome());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
