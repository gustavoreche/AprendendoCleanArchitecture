package empresaA.infraestrutura.util;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import empresaA.infraestrutura.bancoDeDados.ConexaoComBancoDeDadosParaTestesComMock;
import empresaA.infraestrutura.util.exception.BuscaTelefoneException;

public class BuscaTelefoneComJDBCComMockTeste extends ConexaoComBancoDeDadosParaTestesComMock {
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void executa_tudoValido_retornoOk() {
		super.preencheObjetoMockado();
		Assert.assertNotNull(new BuscaTelefoneComJDBC(super.pegaConexao()).executa("111.111.111-18"));
	}

	@Test
	public void executa_semCpf_retornoVazio() {
		Map<String, String> listaDeDddENumero = new BuscaTelefoneComJDBC(super.pegaConexao()).executa(null);
		Assert.assertTrue(listaDeDddENumero != null && listaDeDddENumero.isEmpty());
	}

	@Test
	public void executa_semConexao_retornoException() {
		Assert.assertThrows(BuscaTelefoneException.class, () -> {
			new BuscaTelefoneComJDBC(null).executa("111.111.111-18");
		});
	}

}
