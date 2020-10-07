package empresaA.infraestrutura.funcionario.exception;

public class BuscaFuncionarioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String BUSCA_ERRO = "Erro ao buscar dados do FUNCIONÁRIO. CPF: ";
	
	public BuscaFuncionarioException(String cpf) {
		this(cpf, "");
	}
	
	public BuscaFuncionarioException(String cpf, String mensagem) {
		super(BUSCA_ERRO + cpf + mensagem);
	}

}
