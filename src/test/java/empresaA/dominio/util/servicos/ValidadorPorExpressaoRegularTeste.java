package empresaA.dominio.util.servicos;

import org.junit.Assert;
import org.junit.Test;

import empresaA.dominio.util.exception.ExpressaoRegularInvalidaException;
import empresaA.dominio.util.exception.TextoInvalidoException;
import empresaA.dominio.util.servicos.ValidadorPorExpressaoRegular;


public class ValidadorPorExpressaoRegularTeste {
	
	@Test
	public void construtor_regexValida_retornoOk() {
		String regex = "\\d{3}";
		Assert.assertEquals(regex, new ValidadorPorExpressaoRegular(regex).getExpressaoRegular()); 
	}
	
	@Test
	public void construtor_regexNula_retornoException() {
		Assert.assertThrows(ExpressaoRegularInvalidaException.class, () -> {
			String regex = null;
			new ValidadorPorExpressaoRegular(regex).getExpressaoRegular(); 
		});
	}
	
	@Test
	public void construtor_regexVazia_retornoException() {
		Assert.assertThrows(ExpressaoRegularInvalidaException.class, () -> {
			String regex = "";
			new ValidadorPorExpressaoRegular(regex).getExpressaoRegular(); 
		});
	}
	
	@Test
	public void ehValido_textoValido_retornoOk() {
		String regex = "\\d{3}";
		ValidadorPorExpressaoRegular validador = new ValidadorPorExpressaoRegular(regex);
		Assert.assertTrue(validador.ehValido("123"));
	}
	
	@Test
	public void ehValido_textoInvalido_retornoFalso() {
		String regex = "\\d{3}";
		ValidadorPorExpressaoRegular validador = new ValidadorPorExpressaoRegular(regex);
		Assert.assertFalse(validador.ehValido("1234"));
	}
	
	@Test
	public void ehValido_textoNulo_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			String regex = "\\d{3}";
			ValidadorPorExpressaoRegular validador = new ValidadorPorExpressaoRegular(regex);
			validador.ehValido(null);
		});
	}
	
	@Test
	public void ehValido_textoVazio_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			String regex = "\\d{3}";
			ValidadorPorExpressaoRegular validador = new ValidadorPorExpressaoRegular(regex);
			validador.ehValido("");
		});
	}

}
