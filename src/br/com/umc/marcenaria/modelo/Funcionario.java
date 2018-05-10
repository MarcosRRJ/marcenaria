package br.com.umc.marcenaria.modelo;

import java.util.Date;

public class Funcionario extends Pessoa {

	private Integer idFuncionario;
	private String login;
	private String senha;
	private String status;
	private Departamento departamento;
	private Date dataAdmissao;
	private Date dataDemissao;
	private Integer pessoa;
	private Perfil perfil;

	public Funcionario() {
	}

	public Funcionario(Integer idFuncionario, String login, String senha, String status, Departamento departamento,
			Date dataAdmissao, Date dataDemissao, Integer pessoa, Perfil perfil) {
		this.idFuncionario = idFuncionario;
		this.login = login;
		this.senha = senha;
		this.status = status;
		this.departamento = departamento;
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
		this.pessoa = pessoa;
		this.perfil = perfil;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Integer getPessoa() {
		return pessoa;
	}

	public void setPessoa(Integer pessoa) {
		this.pessoa = pessoa;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}