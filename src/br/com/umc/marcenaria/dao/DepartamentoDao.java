package br.com.umc.marcenaria.dao;

import java.util.List;

import br.com.umc.marcenaria.modelo.Departamento;

public interface DepartamentoDao {

	void cadastrarDepartamento(Departamento departamento);

	List<Departamento> listarDepartamento();

	Departamento pegarUmDepartamento(Integer numeroDeSerie);

	void alterarDepartamento(Integer numeroDeSerie);

	void deleterDepartamento(Integer numeroDeSerie);

}
