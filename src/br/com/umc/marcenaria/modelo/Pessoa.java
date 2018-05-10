package br.com.umc.marcenaria.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pessoa {

	private Integer id;
	private String nome;
	private Date dataNasc;
	private Endereco endereco;
	private List<Documento> documentos = new ArrayList<>();
	private List<Email> emails = new ArrayList<>();
	private List<Telefone> telefones = new ArrayList<>();
	private Cliente cliente;
	private Funcionario funcionario;

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", dataNasc=" + dataNasc + ", endereco=" + endereco
				+ ", documentos=" + documentos + ", emails=" + emails + ", telefones=" + telefones + ", cliente="
				+ cliente + ", funcionario=" + funcionario + "]";
	}

}
