package br.com.umc.marcenaria.modelo;

public class Telefone {

	private Integer idTelefone;
	private String numero;
	private String descricao;
	private Integer idPessoa;

	public Telefone() {
	}
	
	

	public Telefone(Integer idTelefone, String numero, String descricao, Integer idPessoa) {
		this.idTelefone = idTelefone;
		this.numero = numero;
		this.descricao = descricao;
		this.idPessoa = idPessoa;
	}



	public Integer getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", numero=" + numero + ", descricao=" + descricao + ", IdPessoa="
				+ idPessoa + "]";
	}

}
