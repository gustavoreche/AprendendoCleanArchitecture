package empresaA.infraestrutura.util.exception;

public class DeletaTelefoneException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String DELETA_TELEFONE_ERRO = "Erro ao deletar dados do TELEFONE do funcionário ";
	
	public DeletaTelefoneException(String mensagem) {
		super(DELETA_TELEFONE_ERRO + mensagem);
	}

}
