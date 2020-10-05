package empresaA.infraestrutura.funcionario.exception;

public class ContrataFuncionarioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String CONTRATA_ERRO = "Erro ao inserir dados de CONTRATAÇÃO do funcionário ";
	
	public ContrataFuncionarioException(String mensagem) {
		super(CONTRATA_ERRO + mensagem);
	}

}
