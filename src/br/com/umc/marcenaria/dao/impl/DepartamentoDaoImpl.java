package br.com.umc.marcenaria.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.umc.marcenaria.config.ConexaoBancoDeDados;
import br.com.umc.marcenaria.dao.DepartamentoDao;
import br.com.umc.marcenaria.modelo.Departamento;

public class DepartamentoDaoImpl implements DepartamentoDao {

	@Override
	public void cadastrarDepartamento(Departamento departamento) {
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();

			String sqlInsert = "INSERT INTO Departamento(id_departamento, numero_de_serie, descricao) VALUES(departamento_seq.nextval, depart_num_serie_seq.nextval,?)";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, departamento.getDescricao());

			ps.execute();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Departamento> listarDepartamento() {

		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			List<Departamento> departamentos = new ArrayList<>();

			String sqlSelect = "SELECT * FROM Departamento";
			PreparedStatement ps = con.prepareStatement(sqlSelect);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Departamento departamento = new Departamento();
				departamento.setIdDepartamento(rs.getInt("id_departamento"));
				departamento.setNumeroDeSerie(rs.getInt("numero_de_serie"));
				departamento.setDescricao(rs.getString("descricao"));

				departamentos.add(departamento);
			}
			return departamentos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Departamento pegarUmDepartamento(Integer numeroDeSerie) {

		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			Departamento departamento = new Departamento();

			String sqlSelect = "SELECT * FROM Departamento where numero_de_serie = ?";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, numeroDeSerie);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				departamento.setIdDepartamento(rs.getInt("id_departamento"));
				departamento.setNumeroDeSerie(rs.getInt("numero_de_serie"));
				departamento.setDescricao(rs.getString("descricao"));

			}

			return departamento;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterarDepartamento(Integer numeroDeSerie) {

	}

	@Override
	public void deleterDepartamento(Integer numeroDeSerie) {

	}

}
