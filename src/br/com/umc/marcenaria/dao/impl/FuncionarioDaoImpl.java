package br.com.umc.marcenaria.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.umc.marcenaria.config.ConexaoBancoDeDados;
import br.com.umc.marcenaria.dao.FuncionarioDao;
import br.com.umc.marcenaria.modelo.Departamento;
import br.com.umc.marcenaria.modelo.Funcionario;
import br.com.umc.marcenaria.modelo.Perfil;
import br.com.umc.marcenaria.modelo.Pessoa;

public class FuncionarioDaoImpl implements FuncionarioDao {

	@Override
	public Funcionario cadastrarFuncionario(Funcionario funcionario, Perfil perfil, Pessoa pesssoa,
			Departamento departamento) {
		Connection con = new ConexaoBancoDeDados().getConnection();
		Funcionario obj = new Funcionario();
		String generatedColumns[] = { "id_funcionario" };
		try {
			String sqlInsert = "INSERT INTO Funcionario(id_funcionario, login,senha,data_admissao,id_perfil, id_pessoa,  id_departamento, status) VALUES(Funcionario_seq.nextval, ?, ?, ?, ?, ?, ?,  'Ativo')";
			PreparedStatement ps = con.prepareStatement(sqlInsert, generatedColumns);
			ps.setString(1, funcionario.getLogin());
			ps.setString(2, funcionario.getSenha());
			ps.setDate(3, new Date(System.currentTimeMillis()));
			ps.setInt(4, perfil.getIdPerfil());
			ps.setInt(5, funcionario.getPessoa());
			ps.setInt(6, departamento.getIdDepartamento());
			ps.execute();

			try (ResultSet rs = ps.getGeneratedKeys()) {

				if (rs.next()) {
					obj = listarUmFuncionario(rs.getInt(1));
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public List<Funcionario> listarTodosFuncionarios() {

		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			List<Funcionario> funcionarios = new ArrayList<>();

			String sqlSelect = "SELECT * FROM Funcionario c, Perfil per "
					+ "where c.id_perfil = per.id_perfil and status = 'Ativo'";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				Perfil perfil = new Perfil();
				funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
				funcionario.setLogin(rs.getString("login"));
				funcionario.setSenha(rs.getString("senha"));
				// funcionario.setDataCadastro(rs.getDate("data_cadastro"));
				funcionario.setStatus(rs.getString("status"));
				funcionario.setPessoa(rs.getInt("id_pessoa"));
				perfil.setIdPerfil(rs.getInt("id_perfil"));
				perfil.setDescricao(rs.getString("descricao"));
				funcionario.setPerfil(perfil);
				System.out.println(funcionario);

				funcionarios.add(funcionario);
			}

			ps.close();
			con.close();
			return funcionarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Funcionario listarUmFuncionario(Integer login) {
		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			Funcionario funcionario = new Funcionario();

			String sqlSelect = "SELECT * FROM Funcionario c, Perfil per WHERE c.id_pessoa = ? "
					+ " and c.id_perfil = per.id_perfil ";
			PreparedStatement ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, login);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Perfil perfil = new Perfil();
				funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
				funcionario.setLogin(rs.getString("login"));
				funcionario.setSenha(rs.getString("senha"));
				funcionario.setDataAdmissao(rs.getDate("data_admissao"));
				funcionario.setStatus(rs.getString("status"));
				funcionario.setPessoa(rs.getInt("id_pessoa"));
				perfil.setIdPerfil(rs.getInt("id_perfil"));
				perfil.setDescricao(rs.getString("descricao"));
				funcionario.setPerfil(perfil);
			}

			ps.close();
			con.close();
			return funcionario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterarFuncionario(Funcionario funcionario) {

		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			String sqlUpdate = "UPDATE Funcionario SET login =? WHERE id_pessoa =?";
			PreparedStatement ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, funcionario.getLogin());
			ps.setInt(2, funcionario.getPessoa());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleterFuncionario(Integer idFunc) {

		try {
			Connection con = new ConexaoBancoDeDados().getConnection();
			String sqlInsert = "UPDATE Funcionario set status = 'Inativo', data_demissao = ? where id_funcionario = ?  ";
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setDate(1, new Date(System.currentTimeMillis()));
			ps.setInt(2, idFunc);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
