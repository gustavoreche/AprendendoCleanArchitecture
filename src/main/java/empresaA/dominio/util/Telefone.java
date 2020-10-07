package empresaA.dominio.util;

import empresaA.dominio.util.exception.TelefoneInvalidoException;
import empresaA.dominio.util.servicos.ValidadorPorExpressaoRegular;

public class Telefone {
	
	private static final String VALIDA_DDD = "\\d{3}";
	private static final String VALIDA_TELEFONE = "\\d{4,5}-\\d{4}";
	
	private String ddd;
	private String numero;

	public Telefone insere(String ddd, String numero) {
		if(ddd == null || numero == null || !ehValido(ddd, numero))
			throw new TelefoneInvalidoException();
		this.numero = numero;
		this.ddd = ddd;
		return this;
	}

	protected boolean ehValido(String ddd, String numero) {
		return new ValidadorPorExpressaoRegular(VALIDA_DDD).ehValido(ddd) && new ValidadorPorExpressaoRegular(VALIDA_TELEFONE).ehValido(numero);
	}
	
	public String getDdd() {
		return ddd;
	}
	
	public String getNumero() {
		return numero;
	}

}
