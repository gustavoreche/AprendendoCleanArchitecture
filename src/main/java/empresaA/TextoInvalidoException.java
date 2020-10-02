package empresaA;

public class TextoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String TEXTO_INVALIDO = "Texto inválido!";
	
	public TextoInvalidoException() {
		super(TEXTO_INVALIDO);
	}

}
