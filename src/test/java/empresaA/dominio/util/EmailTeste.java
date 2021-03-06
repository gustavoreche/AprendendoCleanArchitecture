package empresaA.dominio.util;

import org.junit.Assert;
import org.junit.Test;

import empresaA.dominio.util.Email;
import empresaA.dominio.util.exception.EmailInvalidoException;
import empresaA.dominio.util.exception.TextoInvalidoException;

public class EmailTeste {
	
	@Test
	public void insere_emailValido_retornoOk() {
		String email = "gustavo@teste.com";
		Assert.assertEquals(email, new Email().insere(email).getEndereco()); 
	}
	
	@Test
	public void insere_emailInvalido_retornoException() {
		Assert.assertThrows(EmailInvalidoException.class, () -> {
			String email = "gustavoteste.com";
			new Email().insere(email);
		});
	}
	
	@Test
	public void insere_emailNulo_retornoException() {
		Assert.assertThrows(EmailInvalidoException.class, () -> {
			String email = null;
			new Email().insere(email);
		});
	}
	
	@Test
	public void insere_emailVazio_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			String email = "";
			new Email().insere(email);
		});
	}

}
