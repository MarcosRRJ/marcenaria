package br.com.umc.marcenaria.dao;

import br.com.umc.marcenaria.modelo.Perfil;

public interface PerfilDao {

	void cadastrarPerfil(Perfil perfil);

	Perfil pegarUmPerfil(String perfil);

	void alterarPerfil(Perfil perfil);

	void deleterPerfil(Perfil perfil);
	
}
