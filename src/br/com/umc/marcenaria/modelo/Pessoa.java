package br.com.umc.marcenaria.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pessoa {

	private Integer id;
	private String nome;
	private Date dataNasc;
	private String status;
	private List<Endereco> enderecos = new ArrayList<>();
	private List<Documento> documentos = new ArrayList<>();
	private List<Email> emails = new ArrayList<>();
	private List<Telefone> telefones = new ArrayList<>();

	public Pessoa() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

}
