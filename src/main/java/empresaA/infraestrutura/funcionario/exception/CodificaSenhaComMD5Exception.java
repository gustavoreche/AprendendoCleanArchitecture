package empresaA.infraestrutura.funcionario.exception;

public class CodificaSenhaComMD5Exception extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String CODIFICA_ERRO = "Erro ao codificar senha do FUNCIONÁRIO";
	
	public CodificaSenhaComMD5Exception() {
		super(CODIFICA_ERRO);
	}

}
