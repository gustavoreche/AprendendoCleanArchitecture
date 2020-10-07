package empresaA.infraestrutura.indicacao.exception;

public class EnviaEmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String ERRO_EMAIL = "Erro ao enviar EMAIL ";
	
	public EnviaEmailException(String mensagem) {
		super(ERRO_EMAIL + mensagem);
	}

}
