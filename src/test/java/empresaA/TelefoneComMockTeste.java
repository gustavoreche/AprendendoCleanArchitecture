package empresaA;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class TelefoneComMockTeste {
	
	@Spy
	private Telefone telefone;
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void insere_telefoneNumeroValido_retornoOk() {
		String ddd = "016";
		String numero = "11111-1111";
		Mockito.doReturn(true).when(this.telefone).ehValido(ddd, numero);
		Assert.assertEquals(numero, this.telefone.insere(ddd, numero).getNumero()); 
	}
	
	@Test
	public void insere_telefoneDddValido_retornoOk() {
		String ddd = "016";
		String numero = "11111-1111";
		Mockito.doReturn(true).when(this.telefone).ehValido(ddd, numero);
		Assert.assertEquals(ddd, this.telefone.insere(ddd, numero).getDdd()); 
	}
	
	@Test
	public void insere_telefoneNumeroInvalido_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			String ddd = "016";
			String numero = "111111-1111";
			Mockito.doReturn(false).when(this.telefone).ehValido(ddd, numero);
			this.telefone.insere(ddd, numero).getNumero(); 
		});
	}
	
	@Test
	public void insere_telefoneDddInvalido_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			String ddd = "16";
			String numero = "11111-1111";
			Mockito.doReturn(false).when(this.telefone).ehValido(ddd, numero);
			this.telefone.insere(ddd, numero).getDdd(); 
		});
	}
	
	@Test
	public void insere_telefoneNumeroNulo_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			String ddd = "016";
			String numero = null;
			Mockito.doReturn(false).when(this.telefone).ehValido(ddd, numero);
			this.telefone.insere(ddd, numero).getNumero(); 
		});
	}
	
	@Test
	public void insere_telefoneDddNulo_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			String ddd = null;
			String numero = "11111-1111";
			Mockito.doReturn(false).when(this.telefone).ehValido(ddd, numero);
			this.telefone.insere(ddd, numero).getDdd(); 
		});
	}
	
	@Test
	public void insere_telefoneNumeroVazio_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			String ddd = "016";
			String numero = "";
			Mockito.doReturn(false).when(this.telefone).ehValido(ddd, numero);
			this.telefone.insere(ddd, numero).getNumero(); 
		});
	}
	
	@Test
	public void insere_telefoneDddVazio_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			String ddd = "";
			String numero = "11111-1111";
			Mockito.doReturn(false).when(this.telefone).ehValido(ddd, numero);
			this.telefone.insere(ddd, numero).getDdd(); 
		});
	}
	
}
