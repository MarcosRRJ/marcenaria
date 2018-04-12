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

	private Connection con = new ConexaoBancoDeDados().getConnection();

	@Override
	public void cadastrarEmail(Email email, Pessoa pessoa) {
		try {
			String sqlInsert = "INSERT INTO Email(id_email, email, id_pessoa) VALUES(email_seq.nextval, ?,?)";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, email.getEmail());
			ps.setInt(2, pessoa.getId());

			ps.execute();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Email> listarEmailPorPessoa(Pessoa pessoa) {

		try {
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
			String sqlUpdate = "UPDATE Email SET email =? WHERE id_email = ?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, email.getEmail());
			ps.setInt(2, email.getIdEmail());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleterEmail(Email email) {
		try {
			String sqlUpdate = "DELETE FROM Email id_email = ?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setInt(1, email.getIdEmail());
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
