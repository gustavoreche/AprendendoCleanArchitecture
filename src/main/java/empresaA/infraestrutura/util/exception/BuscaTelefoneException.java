package empresaA.infraestrutura.util.exception;

public class BuscaTelefoneException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String BUSCA_TELEFONE_ERRO = "Erro ao buscar dados do TELEFONE do funcionário ";
	
	public BuscaTelefoneException(String mensagem) {
		super(BUSCA_TELEFONE_ERRO + mensagem);
	}

}
