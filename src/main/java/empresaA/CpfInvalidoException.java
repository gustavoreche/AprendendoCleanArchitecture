package empresaA;

public class CpfInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String CPF_INVALIDO = "CPF inválido!";
	
	public CpfInvalidoException() {
		super(CPF_INVALIDO);
	}

}
