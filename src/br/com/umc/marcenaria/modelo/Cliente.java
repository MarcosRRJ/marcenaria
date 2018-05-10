package br.com.umc.marcenaria.modelo;

import java.util.Date;

public class Cliente extends Pessoa {

	private Integer idCliente;
	private String login;
	private String senha;
	private String status;
	private Date dataCadastro;
	private Integer pessoa;
	private Perfil perfil;

	public Cliente() {
	}

	public Cliente(Integer idCliente, String login, String senha, String status, Date dataCadastro, Integer pessoa,
			Perfil perfil) {
		this.idCliente = idCliente;
		this.login = login;
		this.senha = senha;
		this.status = status;
		this.dataCadastro = dataCadastro;
		this.pessoa = pessoa;
		this.perfil = perfil;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", login=" + login + ", senha=" + senha + ", status=" + status
				+ ", dataCadastro=" + dataCadastro + ", pessoa=" + pessoa + ", perfil=" + perfil + "]";
	}
	
	

}