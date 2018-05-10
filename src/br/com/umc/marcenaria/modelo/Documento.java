package br.com.umc.marcenaria.modelo;

public class Documento {

	private Integer idDocumento;
	private String numero;
	private String descricao;
	private Integer IdPessoa;

	public Documento() {

	}

	public Documento(Integer idDocumento, String numero, String descricao, Integer idPessoa) {
		this.idDocumento = idDocumento;
		this.numero = numero;
		this.descricao = descricao;
		IdPessoa = idPessoa;
	}

	public Integer getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
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
		return IdPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		IdPessoa = idPessoa;
	}

}
