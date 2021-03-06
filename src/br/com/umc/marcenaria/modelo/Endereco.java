package br.com.umc.marcenaria.modelo;

public class Endereco {

	private Integer idEndereco;
	private String pais;
	private String estado;
	private String cidade;
	private String bairro;
	private String logadouro;
	private String cep;
	private String complemento;
	private Integer IdPessoa;

	public Endereco() {
	}

	public Endereco(Integer idEndereco, String pais, String estado, String cidade, String bairro, String logadouro,
			String cep, String complemento, Integer idPessoa) {
		this.idEndereco = idEndereco;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.logadouro = logadouro;
		this.cep = cep;
		this.complemento = complemento;
		IdPessoa = idPessoa;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogadouro() {
		return logadouro;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getIdPessoa() {
		return IdPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		IdPessoa = idPessoa;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", pais=" + pais + ", estado=" + estado + ", cidade=" + cidade
				+ ", bairro=" + bairro + ", logadouro=" + logadouro + ", cep=" + cep + ", complemento=" + complemento
				+ ", IdPessoa=" + IdPessoa + "]";
	}
	
}
