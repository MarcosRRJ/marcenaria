package br.com.umc.marcenaria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.umc.marcenaria.config.ConexaoBancoDeDados;
import br.com.umc.marcenaria.dao.TelefoneDao;
import br.com.umc.marcenaria.modelo.Pessoa;
import br.com.umc.marcenaria.modelo.Telefone;

public class TelefoneDaoImpl implements TelefoneDao {

	@Override
	public void cadastrarTelefone(Telefone telefone, Pessoa pessoa) {
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();

			String sqlInsert = "INSERT INTO Telefone(id_telefone, numero, descricao, id_pessoa) VALUES(telefone_seq.nextval, ?,?,?)";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, telefone.getNumero());
			ps.setString(2, telefone.getDescricao());
			ps.setInt(3, pessoa.getId());

			ps.execute();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Telefone> listarTelefonePorPessoa(Pessoa pessoa) {

		try {
			Connection con = new ConexaoBancoDeDados().getConnection();

			List<Telefone> telefones = new ArrayList<>();

			String sqlSelect = "SELECT * FROM Telefone where id_pessoa = ?";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, pessoa.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Telefone telefone = new Telefone();
				telefone.setIdTelefone(rs.getInt("id_telefone"));
				telefone.setNumero(rs.getString("numero"));
				telefone.setDescricao(rs.getString("descricao"));
				telefone.setIdPessoa(rs.getInt("id_pessoa"));

				telefones.add(telefone);
			}
			ps.close();
			con.close();
			return telefones;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterarTelefone(List<Telefone> listTelefones, Pessoa pessoa) {

		int i = 0;
		for (Telefone telefone : listTelefones) {
			if ((pessoa.getTelefones().size() > 0)
					|| (pessoa.getTelefones().get(i).getDescricao().equals(telefone.getDescricao()))) {

				try {
					Connection con = new ConexaoBancoDeDados().getConnection();

					String sqlUpdate = "UPDATE Telefone SET numero =? WHERE id_telefone = ?";
					PreparedStatement ps = con.prepareStatement(sqlUpdate);
					ps.setString(1, telefone.getNumero());
					ps.setInt(2, pessoa.getTelefones().get(i).getIdTelefone());
					ps.executeUpdate();

					ps.close();
					con.close();
					i++;
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else {
				cadastrarTelefone(telefone, pessoa);
			}
		}
	}

	@Override
	public void deleterTelefone(Telefone telefone) {
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();

			String sqlUpdate = "DELETE FROM Telefone where numero like ?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, telefone.getNumero());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
