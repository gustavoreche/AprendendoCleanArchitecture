package empresaA.infraestrutura.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import empresaA.dominio.funcionario.FuncionarioBuilder;
import empresaA.infraestrutura.funcionario.CodificadorDeSenhaComMD5;
import empresaA.infraestrutura.util.exception.DeletaTelefoneException;

public class DeletaTelefoneComJDBCTeste {
	
	private static Connection conexao;
	
	@BeforeClass
	public static void configuracoesIniciais() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/empresaA?useTimezone=true&serverTimezone=UTC", "root", "123456");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
