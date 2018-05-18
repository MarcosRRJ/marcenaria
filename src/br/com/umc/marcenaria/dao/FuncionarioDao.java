package br.com.umc.marcenaria.dao;

import java.util.List;

import br.com.umc.marcenaria.modelo.Departamento;
import br.com.umc.marcenaria.modelo.Funcionario;
import br.com.umc.marcenaria.modelo.Perfil;
import br.com.umc.marcenaria.modelo.Pessoa;

public interface FuncionarioDao {

	Funcionario cadastrarFuncionario(Funcionario funcionario, Perfil perfil, Pessoa pesssoa, Departamento departamento);

	List<Funcionario> listarTodosFuncionarios();

	Funcionario listarUmFuncionario(Integer login);

	void alterarFuncionario(Funcionario funcionario);

	void deleterFuncionario(Integer idFunc);

}
	