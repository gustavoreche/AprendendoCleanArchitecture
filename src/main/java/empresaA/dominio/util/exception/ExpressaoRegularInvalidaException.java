package empresaA.dominio.util.exception;

public class ExpressaoRegularInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String EXPRESSAO_REGULAR_INVALIDA = "Expressão regular inválida!";
	
	public ExpressaoRegularInvalidaException() {
		super(EXPRESSAO_REGULAR_INVALIDA);
	}

}
