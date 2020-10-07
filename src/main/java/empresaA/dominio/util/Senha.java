package empresaA.dominio.util;

import empresaA.dominio.funcionario.exception.SenhaInvalidaException;
import empresaA.dominio.funcionario.servicos.CodificadorDeSenha;

public class Senha {
	
	private String senhaCodificada;
	private CodificadorDeSenha codificador;
	
	public Senha(CodificadorDeSenha codificador) {
		this.codificador = codificador;
	}
	
	public Senha insere(String senha) {
		if(senha == null || senha.isEmpty())
			throw new SenhaInvalidaException();
		this.senhaCodificada = codificaSenha(senha);
		return this;
	}
	
	private String codificaSenha(String senha) {
		String senhaCodificada = this.codificador.codificaSenha(senha);
		if(senhaCodificada == null || senhaCodificada.isEmpty())
			throw new SenhaInvalidaException();
		return senhaCodificada;
	}
	
	public String getSenhaCodificada() {
		return this.senhaCodificada;
	}

}
