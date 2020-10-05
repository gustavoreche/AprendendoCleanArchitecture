package empresaA.dominio.util.exception;

public class TelefoneInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String TELEFONE_INVALIDO = "Telefone inválido!";
	
	public TelefoneInvalidoException() {
		super(TELEFONE_INVALIDO);
	}

}
