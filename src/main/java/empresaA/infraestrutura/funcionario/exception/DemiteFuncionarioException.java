package empresaA.infraestrutura.funcionario.exception;

public class DemiteFuncionarioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String DEMITE_ERRO = "Erro ao excluir dados do FUNCIONÁRIO ";
	
	public DemiteFuncionarioException(String mensagem) {
		super(DEMITE_ERRO + mensagem);
	}

}
