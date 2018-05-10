package br.com.umc.marcenaria.modelo;

public class Email {

	private Integer idEmail;
	private String email;
	private Integer idPessoa;

	public Email() {
	}

	public Email(Integer idEmail, String email, Integer idPessoa) {
		this.idEmail = idEmail;
		this.email = email;
		this.idPessoa = idPessoa;
	}

	public Integer getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(Integer idEmail) {
		this.idEmail = idEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
}
