package empresaA.dominio.funcionario.servicos;

public interface CodificadorDeSenha {
	
	String codificaSenha(String senha);
	
	boolean validaSenha(String senhaCodificada, String senhaDigitada);

}
