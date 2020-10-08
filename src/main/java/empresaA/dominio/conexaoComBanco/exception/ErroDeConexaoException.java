package empresaA.dominio.conexaoComBanco.exception;

public class ErroDeConexaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final String ERRO_DE_CONEXAO = "Erro de conexão ";
	
	public ErroDeConexaoException(String mensagem) {
		super(ERRO_DE_CONEXAO + mensagem);
	}

}
