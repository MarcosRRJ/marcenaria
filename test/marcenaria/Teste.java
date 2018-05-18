package marcenaria;

import br.com.umc.marcenaria.util.ValidadorCPF;

public class Teste {

	public static void main(String[] args) {
		System.out.println("### Código para validar CPF em Java {varejao.org} ###");
		String cpf1 = "40776942808";
		String cpf2 = "33333333333";

		ValidadorCPF validador = new ValidadorCPF();
		boolean resultado1 = validador.isValido(cpf1);
		boolean resultado2 = validador.isValido(cpf2);

		System.out.println("Resultado da validação de " + cpf1 + " é " + resultado1);
		System.out.println("Resultado da validação de " + cpf2 + " é " + resultado2);
	}

}
