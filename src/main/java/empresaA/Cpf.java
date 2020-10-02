package empresaA;

public class Cpf {

	private static final String VALIDA_CPF = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";

	public String insere(String numero) {
		if(numero == null || !ehValido(numero))
			throw new CpfInvalidoException();
		return numero;
	}

	protected boolean ehValido(String numero) {
		return new ValidadorPorExpressaoRegular(VALIDA_CPF).ehValido(numero);
	}

}
