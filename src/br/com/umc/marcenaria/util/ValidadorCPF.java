package br.com.umc.marcenaria.util;

public class ValidadorCPF {

	public boolean isValido(String cpfSemFormatacao) {

		if (cpfSemFormatacao.length() != 11 || cpfSemFormatacao.equals("00000000000") || cpfSemFormatacao.equals("11111111111") ||
		        cpfSemFormatacao.equals("22222222222") || cpfSemFormatacao.equals("33333333333") ||
		        cpfSemFormatacao.equals("44444444444") || cpfSemFormatacao.equals("55555555555") ||
		        cpfSemFormatacao.equals("66666666666") || cpfSemFormatacao.equals("77777777777") ||
		        cpfSemFormatacao.equals("88888888888") || cpfSemFormatacao.equals("99999999999")) {
			return false;
		}

		String digitos = cpfSemFormatacao.substring(0, 9);
		;
		String dvs = cpfSemFormatacao.substring(9, 11);

		String dv1 = gerarDV(digitos);
		String dv2 = gerarDV(digitos + dv1);

		return dvs.equals(dv1 + dv2);
	}

	private String gerarDV(String digitos) {
		int peso = digitos.length() + 1;
		int dv = 0;
		for (int i = 0; i < digitos.length(); i++) {
			dv += Integer.parseInt(digitos.substring(i, i + 1)) * peso;
			peso--;
		}

		dv = 11 - (dv % 11);

		if (dv > 9) {
			return "0";
		}

		return String.valueOf(dv);
	}
}