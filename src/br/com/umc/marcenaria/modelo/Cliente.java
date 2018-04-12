package br.com.umc.marcenaria.modelo;

public class Cliente extends Pessoa {

	private Integer idCliente;
	private String login;
	private String senha;
	private String status;
	private Integer perfil;

	public Cliente() {
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

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", login=" + login + ", senha=" + senha + ", status=" + status
				+ ", perfil=" + perfil + "]";
	}

}