package br.com.umc.marcenaria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.umc.marcenaria.config.ConexaoBancoDeDados;
import br.com.umc.marcenaria.dao.ImagemDao;
import br.com.umc.marcenaria.modelo.Email;

public class ImagemDaoImpl implements ImagemDao {

	@Override
	public void cadastrarDocumento(String imagem, Integer idInteger) {
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			
			String sqlInsert = "INSERT INTO imagemProduto(id_imagem, nome_imagem, id_Produto) VALUES(imagemProduto_seq.nextval, ?,1)";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, imagem);

			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> listarDocumentoPorPessoa(Integer idProduto) {
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			
			List<String> imagens = new ArrayList<>();

			String sqlSelect = "SELECT * FROM imagemProduto where id_Produto = ?";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, idProduto);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				imagens.add(rs.getString("nome_imagem"));
			}
			return imagens;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
