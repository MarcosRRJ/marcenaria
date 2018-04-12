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

	private Connection con = new ConexaoBancoDeDados().getConnection();

	@Override
	public void cadastrarTelefone(Telefone telefone, Pessoa pessoa) {
		try {
			String sqlInsert = "INSERT INTO Telefone(id_telefone, numero, descricao, id_pessoa) VALUES(teledone_seq.nextval, ?,?,?)";
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
				telefone.setIdPessoa(pessoa.getId());

				telefones.add(telefone);
			}
			return telefones;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterarTelefone(Telefone telefone) {

		try {
			String sqlUpdate = "UPDATE Telefone SET numero =?, descricao=? WHERE id_telefone = ?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, telefone.getNumero());
			ps.setString(2, telefone.getDescricao());
			ps.setInt(3, telefone.getIdTelefone());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleterTelefone(Telefone telefone) {
		try {
			String sqlUpdate = "DELETE FROM Telefone id_telefone = ?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setInt(1, telefone.getIdTelefone());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
