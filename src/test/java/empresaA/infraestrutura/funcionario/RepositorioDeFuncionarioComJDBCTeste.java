package empresaA.infraestrutura.funcionario;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.dominio.funcionario.FuncionarioBuilder;

public class RepositorioDeFuncionarioComJDBCTeste {
	
	private static Connection conexao;
	
	private RepositorioDeFuncionarioComJDBC repositorio;
	
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
		this.repositorio = new RepositorioDeFuncionarioComJDBC(conexao);		
	}
	
	@Test
	public void demite_tudoValido_retornoOk() {
		Assert.assertTrue(this.repositorio.demite(new FuncionarioBuilder("111.111.111-18", "Gustavo").cria()));
	}
	
	@Test
	public void contrata_tudoValido_retornoOk() {
		Funcionario funcionario = new FuncionarioBuilder("111.111.111-18", "Gustavo").cria();
		this.repositorio.demite(funcionario);
		Assert.assertTrue(this.repositorio.contrata(funcionario));
	}
	
}
