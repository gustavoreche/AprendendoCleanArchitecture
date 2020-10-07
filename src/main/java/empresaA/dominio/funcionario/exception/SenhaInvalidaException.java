package empresaA.dominio.funcionario.exception;

public class SenhaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String SENHA_INVALIDA = "Senha inválida!";
	
	public SenhaInvalidaException() {
		super(SENHA_INVALIDA);
	}

}
