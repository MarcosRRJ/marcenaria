package br.com.umc.marcenaria.util;

import java.util.ArrayList;
import java.util.List;

public class Erro {

	private List<String> erroVazio = new ArrayList<>();
	private List<String> erroDeTipo = new ArrayList<>();
	private String cpf;

	public List<String> getErroVazio() {
		return erroVazio;
	}

	public void setErroVazio(List<String> erroVazio) {
		this.erroVazio = erroVazio;
	}

	public List<String> getErroDeTipo() {
		return erroDeTipo;
	}

	public void setErroDeTipo(List<String> erroDeTipo) {
		this.erroDeTipo = erroDeTipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
