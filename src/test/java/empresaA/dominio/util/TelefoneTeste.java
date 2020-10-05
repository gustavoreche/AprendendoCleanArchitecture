package empresaA.dominio.util;

import org.junit.Assert;
import org.junit.Test;

import empresaA.dominio.util.Telefone;
import empresaA.dominio.util.exception.TelefoneInvalidoException;
import empresaA.dominio.util.exception.TextoInvalidoException;

public class TelefoneTeste {
	
	@Test
	public void insere_telefoneNumeroValido_retornoOk() {
		String ddd = "016";
		String numero = "11111-1111";
		Assert.assertEquals(numero, new Telefone().insere(ddd, numero).getNumero()); 
	}
	
	@Test
	public void insere_telefoneDddValido_retornoOk() {
		String ddd = "016";
		String numero = "11111-1111";
		Assert.assertEquals(ddd, new Telefone().insere(ddd, numero).getDdd()); 
	}
	
	@Test
	public void insere_telefoneNumeroInvalido_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			String ddd = "016";
			String numero = "111111-1111";
			new Telefone().insere(ddd, numero).getNumero(); 
		});
	}
	
	@Test
	public void insere_telefoneDddInvalido_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			String ddd = "16";
			String numero = "11111-1111";
			new Telefone().insere(ddd, numero).getDdd(); 
		});
	}
	
	@Test
	public void insere_telefoneNumeroNulo_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			String ddd = "016";
			String numero = null;
			new Telefone().insere(ddd, numero).getNumero(); 
		});
	}
	
	@Test
	public void insere_telefoneDddNulo_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			String ddd = null;
			String numero = "11111-1111";
			new Telefone().insere(ddd, numero).getDdd(); 
		});
	}
	
	@Test
	public void insere_telefoneNumeroVazio_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			String ddd = "016";
			String numero = "";
			new Telefone().insere(ddd, numero).getNumero(); 
		});
	}
	
	@Test
	public void insere_telefoneDddVazio_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			String ddd = "";
			String numero = "11111-1111";
			new Telefone().insere(ddd, numero).getDdd(); 
		});
	}
	
}
