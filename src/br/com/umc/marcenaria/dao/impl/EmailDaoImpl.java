package br.com.umc.marcenaria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.umc.marcenaria.config.ConexaoBancoDeDados;
import br.com.umc.marcenaria.dao.EmailDao;
import br.com.umc.marcenaria.modelo.Pessoa;
import br.com.umc.marcenaria.modelo.Email;

public class EmailDaoImpl implements EmailDao {

	@Override
	public Email cadastrarEmail(Email email, Pessoa pessoa) {
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			
			String sqlInsert = "INSERT INTO Email(id_email, email, id_pessoa) VALUES(email_seq.nextval, ?,?)";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, email.getEmail());
			ps.setInt(2, pessoa.getId());

			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return email;

	}

	@Override
	public List<Email> listarEmailPorPessoa(Pessoa pessoa) {

		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			
			List<Email> emails = new ArrayList<>();

			String sqlSelect = "SELECT * FROM Email where id_pessoa = ?";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, pessoa.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Email email = new Email();
				email.setIdEmail(rs.getInt("id_email"));
				email.setEmail(rs.getString("email"));
				email.setIdPessoa(pessoa.getId());
				
				emails.add(email);
			}
			return emails;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterarEmail(Email email) {

		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			
			String sqlUpdate = "UPDATE Email SET email =? WHERE id_pessoa = ?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, email.getEmail());
			ps.setInt(2, email.getIdPessoa());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletarEmail(Email email) {
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			
			String sqlUpdate = "DELETE FROM Email where email like ?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, email.getEmail());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Email pegarUmEmail(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
