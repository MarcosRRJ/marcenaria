package br.com.umc.marcenaria.modelo;

public class Departamento {

	private Integer idDepartamento;
	private Integer numeroDeSerie;
	private String descricao;

	public Departamento() {

	}

	public Departamento(Integer idDepartamento, Integer numeroDeSerie, String descricao) {
		this.idDepartamento = idDepartamento;
		this.numeroDeSerie = numeroDeSerie;
		this.descricao = descricao;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Integer getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(Integer numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
