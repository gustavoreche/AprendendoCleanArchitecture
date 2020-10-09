package empresaA.dominio.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import empresaA.dominio.funcionario.exception.SenhaInvalidaException;
import empresaA.dominio.funcionario.servicos.CodificadorDeSenha;

public class SenhaComMockTeste {

	private CodificadorDeSenha codificador;

	@Before
	public void iniciaAntesDeCadaTeste() {
		this.codificador = Mockito.mock(CodificadorDeSenha.class);
		Mockito.doReturn("1a2b3c").when(this.codificador).codificaSenha(Matchers.anyString());
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
