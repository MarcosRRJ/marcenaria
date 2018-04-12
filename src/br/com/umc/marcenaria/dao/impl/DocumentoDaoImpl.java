package br.com.umc.marcenaria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.umc.marcenaria.config.ConexaoBancoDeDados;
import br.com.umc.marcenaria.dao.DocumentoDao;
import br.com.umc.marcenaria.modelo.Pessoa;
import br.com.umc.marcenaria.modelo.Documento;

public class DocumentoDaoImpl implements DocumentoDao {

	private Connection con = new ConexaoBancoDeDados().getConnection();

	@Override
	public void cadastrarDocumento(Documento documento, Pessoa pessoa) {
		try {
			String sqlInsert = "INSERT INTO Documento(id_documento, numero, descricao, id_pessoa) VALUES(documento_seq.nextval, ?,?,?)";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, documento.getNumero());
			ps.setString(2, documento.getDescricao());
			ps.setInt(3, pessoa.getId());

			ps.execute();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Documento> listarDocumentoPorPessoa(Pessoa pessoa) {

		try {
			List<Documento> documentos = new ArrayList<>();

			String sqlSelect = "SELECT * FROM Documento where id_pessoa = ?";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, pessoa.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Documento documento = new Documento();
				documento.setIdDocumento(rs.getInt("id_documento"));
				documento.setNumero(rs.getString("numero"));
				documento.setDescricao(rs.getString("descricao"));
				documento.setIdPessoa(pessoa.getId());

				documentos.add(documento);
			}
			return documentos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterarDocumento(Documento documento) {

		try {
			String sqlUpdate = "UPDATE Documento SET numero =?, descricao=? WHERE id_documento = ?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, documento.getNumero());
			ps.setString(2, documento.getDescricao());
			ps.setInt(3, documento.getIdDocumento());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleterDocumento(Documento documento) {
		try {
			String sqlUpdate = "DELETE FROM Documento id_documento = ?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setInt(1, documento.getIdDocumento());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Documento pegarUmDocumento(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
