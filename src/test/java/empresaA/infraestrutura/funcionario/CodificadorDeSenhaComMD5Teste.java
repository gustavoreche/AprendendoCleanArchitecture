package empresaA.infraestrutura.funcionario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import empresaA.infraestrutura.funcionario.exception.CodificaSenhaComMD5Exception;

public class CodificadorDeSenhaComMD5Teste {
	
	private CodificadorDeSenhaComMD5 codificador;
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		this.codificador = new CodificadorDeSenhaComMD5();
	}
	
	@Test
	public void codificaSenha_tudoValido_retornoOk() {
		String senha = "1234";
		Assert.assertNotEquals(senha, this.codificador.codificaSenha(senha));
	}
	
	@Test
	public void codificaSenha_senhaNula_retornoException() {
		Assert.assertThrows(CodificaSenhaComMD5Exception.class, () -> {
			String senha = null;
			Assert.assertNotEquals(senha, this.codificador.codificaSenha(senha));
		});
	}
	
	@Test
	public void validaSenha_tudoValido_retornoOk() {
		String senha = "1234";
		Assert.assertTrue(this.codificador.validaSenha(this.codificador.codificaSenha(senha), senha));
	}
	
	@Test
	public void validaSenha_senhaInvalida_retornoOk() {
		String senha = "1234";
		Assert.assertFalse(this.codificador.validaSenha(this.codificador.codificaSenha("999"), senha));
	}
	
	@Test
	public void validaSenha_senhaNula_retornoException() {
		Assert.assertThrows(CodificaSenhaComMD5Exception.class, () -> {
			this.codificador.validaSenha(this.codificador.codificaSenha("999"), null);
		});
	}
	
	@Test
	public void validaSenha_senhaVazia_retornoException() {
		Assert.assertFalse(this.codificador.validaSenha(this.codificador.codificaSenha("999"), ""));
	}
	
}
