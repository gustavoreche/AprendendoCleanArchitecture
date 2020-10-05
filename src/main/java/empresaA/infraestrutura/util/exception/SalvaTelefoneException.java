package empresaA.infraestrutura.util.exception;

public class SalvaTelefoneException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String SALVA_TELEFONE_ERRO = "Erro ao inserir dados do TELEFONE do funcionário ";
	
	public SalvaTelefoneException(String mensagem) {
		super(SALVA_TELEFONE_ERRO + mensagem);
	}

}
