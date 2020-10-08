package empresaA.infraestrutura.util;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import empresaA.dominio.funcionario.FuncionarioBuilder;
import empresaA.infraestrutura.conexaoComBanco.ConexaoComMySQL;
import empresaA.infraestrutura.funcionario.CodificadorDeSenhaComMD5;
import empresaA.infraestrutura.util.exception.DeletaTelefoneException;

public class DeletaTelefoneComJDBCTeste {
	
	private static Connection conexao = new ConexaoComMySQL().cria();
	
	@Test
	public void executa_tudoValido_retornoOk() {
		Assert.assertTrue(new DeletaTelefoneComJDBC(conexao).executa(new FuncionarioBuilder("111.111.111-18", "Gustavo", "1234", new CodificadorDeSenhaComMD5()).cria()));
	}
	
	@Test
	public void executa_semFuncionario_retornoException() {
		Assert.assertThrows(DeletaTelefoneException.class, () -> {
			Assert.assertTrue(new DeletaTelefoneComJDBC(conexao).executa(null));
		});
	}
	
	@Test
	public void executa_semConexao_retornoException() {
		Assert.assertThrows(DeletaTelefoneException.class, () -> {
			Assert.assertTrue(new DeletaTelefoneComJDBC(null).executa(new FuncionarioBuilder("111.111.111-18", "Gustavo", "1234", new CodificadorDeSenhaComMD5()).cria()));
		});
	}

}
