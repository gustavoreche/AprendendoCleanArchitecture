package empresaA.dominio.util;

import org.junit.Assert;
import org.junit.Test;

import empresaA.dominio.util.Cpf;
import empresaA.dominio.util.exception.CpfInvalidoException;
import empresaA.dominio.util.exception.TextoInvalidoException;

public class CpfTeste {
	
	@Test
	public void insere_cpfValido_retornoOk() {
		String cpf = "111.111.111-11";
		Assert.assertEquals(cpf, new Cpf().insere(cpf).getNumero()); 
	}
	
	@Test
	public void insere_cpfInvalido_retornoException() {
		Assert.assertThrows(CpfInvalidoException.class, () -> {
			String cpf = "111111111-11";
			new Cpf().insere(cpf);
		});
	}
	
	@Test
	public void insere_cpfNulo_retornoException() {
		Assert.assertThrows(CpfInvalidoException.class, () -> {
			String cpf = null;
			new Cpf().insere(cpf);
		});
	}
	
	@Test
	public void insere_cpfVazio_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			String cpf = "";
			new Cpf().insere(cpf);
		});
	}

}
