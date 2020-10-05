package empresaA.dominio.util;

import empresaA.dominio.util.exception.EmailInvalidoException;

public class Email {
	
	private static final String VALIDA_EMAIL = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	
	private String endereco;
	
	public Email insere(String endereco) {
		if(endereco == null || !ehValido(endereco))
			throw new EmailInvalidoException();
		this.endereco = endereco;
		return this;
	}

	protected boolean ehValido(String numero) {
		return new ValidadorPorExpressaoRegular(VALIDA_EMAIL).ehValido(numero);
	}
	
	public String getEndereco() {
		return endereco;
	}
	
}
