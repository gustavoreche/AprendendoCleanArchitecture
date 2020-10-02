package empresaA;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class CpfComMockTeste {
	
	@Spy
	private Cpf cpf;
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void insere_cpfValido_retornoOk() {
		String cpf = "111.111.111-11";
		Mockito.doReturn(true).when(this.cpf).ehValido(cpf);
		Assert.assertEquals(cpf, this.cpf.insere(cpf).getNumero()); 
	}
	
	@Test
	public void insere_cpfInvalido_retornoException() {
		Assert.assertThrows(CpfInvalidoException.class, () -> {
			String cpf = "111111111-11";
			Mockito.doReturn(false).when(this.cpf).ehValido(cpf);
			this.cpf.insere(cpf);
		});
	}
	
	@Test
	public void insere_cpfNulo_retornoException() {
		Assert.assertThrows(CpfInvalidoException.class, () -> {
			String cpf = null;
			Mockito.doReturn(false).when(this.cpf).ehValido(cpf);
			this.cpf.insere(cpf);
		});
	}
	
	@Test
	public void insere_cpfVazio_retornoException() {
		Assert.assertThrows(CpfInvalidoException.class, () -> {
			String cpf = "";
			Mockito.doReturn(false).when(this.cpf).ehValido(cpf);
			this.cpf.insere(cpf);
		});
	}
	
}
