package empresaA.dominio.funcionario.exception;

public class NomeInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String NOME_INVALIDO = "Nome inválido!";
	
	public NomeInvalidoException() {
		super(NOME_INVALIDO);
	}

}
