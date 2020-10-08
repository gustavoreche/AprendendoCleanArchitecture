package empresaA.infraestrutura.util;

import java.sql.Connection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import empresaA.infraestrutura.conexaoComBanco.ConexaoComMySQL;
import empresaA.infraestrutura.util.exception.BuscaTelefoneException;

public class BuscaTelefoneComJDBCTeste {

	private static Connection conexao = new ConexaoComMySQL().cria();

	@Test
	public void executa_tudoValido_retornoOk() {
		Assert.assertNotNull(new BuscaTelefoneComJDBC(conexao).executa("111.111.111-18"));
	}

	@Test
	public void executa_semCpf_retornoVazio() {
		Map<String, String> listaDeDddENumero = new BuscaTelefoneComJDBC(conexao).executa(null);
		Assert.assertTrue(listaDeDddENumero != null && listaDeDddENumero.isEmpty());
	}

	@Test
	public void executa_semConexao_retornoException() {
		Assert.assertThrows(BuscaTelefoneException.class, () -> {
			new BuscaTelefoneComJDBC(null).executa("111.111.111-18");
		});
	}

}
