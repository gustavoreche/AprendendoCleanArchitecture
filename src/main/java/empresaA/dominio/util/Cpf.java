package empresaA.dominio.util;

import empresaA.dominio.util.exception.CpfInvalidoException;
import empresaA.dominio.util.servicos.ValidadorPorExpressaoRegular;

public class Cpf {

	private static final String VALIDA_CPF = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
	
	private String numero;

	public Cpf insere(String numero) {
		if(numero == null || !ehValido(numero))
			throw new CpfInvalidoException();
		this.numero = numero;
		return this;
	}

	protected boolean ehValido(String numero) {
		return new ValidadorPorExpressaoRegular(VALIDA_CPF).ehValido(numero);
	}
	
	public String getNumero() {
		return numero;
	}

}
