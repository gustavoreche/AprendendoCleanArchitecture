package empresaA.infraestrutura.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.dominio.funcionario.FuncionarioBuilder;
import empresaA.infraestrutura.util.exception.SalvaTelefoneException;

public class InsereTelefoneComJDBCTeste {
	
	private static Connection conexao;
	
	private Funcionario funcionario;
	
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
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		this.funcionario = new FuncionarioBuilder("111.111.111-18", "Gustavo").cria();
		new DeletaTelefoneComJDBC(conexao).executa(this.funcionario);
	}
	
	@Test
	public void executa_tudoValido_retornoOk() {
		Assert.assertTrue(new InsereTelefoneComJDBC(conexao).executa(this.funcionario));
	}
	
	@Test
	public void executa_semFuncionario_retornoException() {
		Assert.assertThrows(SalvaTelefoneException.class, () -> {
			Assert.assertTrue(new InsereTelefoneComJDBC(conexao).executa(null));
		});
	}
	
	@Test
	public void executa_semConexao_retornoException() {
		Assert.assertThrows(SalvaTelefoneException.class, () -> {
			Assert.assertTrue(new InsereTelefoneComJDBC(null).executa(this.funcionario));
		});
	}

}
