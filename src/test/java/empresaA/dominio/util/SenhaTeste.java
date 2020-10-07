package empresaA.dominio.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import empresaA.dominio.funcionario.exception.SenhaInvalidaException;
import empresaA.infraestrutura.funcionario.CodificadorDeSenhaComMD5;

public class SenhaTeste {
	
	private CodificadorDeSenhaComMD5 codificador;
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		this.codificador = new CodificadorDeSenhaComMD5();		
	}
	
	@Test
	public void insere_senhaValida_retornoOk() {
		String senha = "1234";
		Assert.assertEquals(this.codificador.codificaSenha(senha), new Senha(this.codificador).insere(senha).getSenhaCodificada()); 
	}
	
	@Test
	public void insere_senhaNula_retornoException() {
		Assert.assertThrows(SenhaInvalidaException.class, () -> {
			String senha = null;
			new Senha(this.codificador).insere(senha).getSenhaCodificada();
		});
	}
	
	@Test
	public void insere_senhaVazia_retornoException() {
		Assert.assertThrows(SenhaInvalidaException.class, () -> {
			String senha = "";
			new Senha(this.codificador).insere(senha).getSenhaCodificada();
		});
	}

}
