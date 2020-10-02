package empresaA;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class EmailComMockTeste {
	
	@Spy
	private Email email;
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void insere_emailValido_retornoOk() {
		String email = "gustavo@teste.com";
		Mockito.doReturn(true).when(this.email).ehValido(email);
		Assert.assertEquals(email, this.email.insere(email).getEndereco()); 
	}
	
	@Test
	public void insere_emailInvalido_retornoException() {
		Assert.assertThrows(EmailInvalidoException.class, () -> {
			String email = "gustavoteste.com";
			Mockito.doReturn(false).when(this.email).ehValido(email);
			this.email.insere(email);
		});
	}
	
	@Test
	public void insere_emailNulo_retornoException() {
		Assert.assertThrows(EmailInvalidoException.class, () -> {
			String email = null;
			Mockito.doReturn(false).when(this.email).ehValido(email);
			this.email.insere(email);
		});
	}
	
	@Test
	public void construtor_emailVazio_retornoException() {
		Assert.assertThrows(EmailInvalidoException.class, () -> {
			String email = "";
			Mockito.doReturn(false).when(this.email).ehValido(email);
			this.email.insere(email);
		});
	}
	
}
