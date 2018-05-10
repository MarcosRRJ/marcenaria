package br.com.umc.marcenaria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.umc.marcenaria.config.ConexaoBancoDeDados;
import br.com.umc.marcenaria.dao.PerfilDao;
import br.com.umc.marcenaria.modelo.Perfil;

public class PerfilDaoImpl implements PerfilDao {

	@Override
	public void cadastrarPerfil(Perfil perfil) {
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			
			String sqlInsert = "INSERT INTO Perfil(id_perfil, descricao) VALUES(perfil_seq.nextval, ?)";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, perfil.getDescricao());

			ps.execute();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Perfil pegarUmPerfil(String perfil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterarPerfil(Perfil perfil) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleterPerfil(Perfil perfil) {
		// TODO Auto-generated method stub

	}

}
