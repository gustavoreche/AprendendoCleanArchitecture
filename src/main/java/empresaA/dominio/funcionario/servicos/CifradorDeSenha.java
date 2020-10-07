package empresaA.dominio.funcionario.servicos;

public interface CifradorDeSenha {
	
	String codificaSenha(String senha);
	
	boolean validaSenha(String senhaCodificada, String senhaDigitada);

}
