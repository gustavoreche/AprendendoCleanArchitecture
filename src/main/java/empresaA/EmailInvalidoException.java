package empresaA;

public class EmailInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String EMAIL_INVALIDO = "E-mail inválido!";
	
	public EmailInvalidoException() {
		super(EMAIL_INVALIDO);
	}

}
