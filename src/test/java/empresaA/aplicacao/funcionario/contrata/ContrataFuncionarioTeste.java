package empresaA.aplicacao.funcionario.contrata;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import empresaA.infraestrutura.funcionario.RepositorioDeFuncionarioComJDBC;

public class ContrataFuncionarioTeste {
	
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
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO("111.111.111-18", 
				"Gustavo", "", "12", null);
		RepositorioDeFuncionarioComJDBC repositorio = new RepositorioDeFuncionarioComJDBC(conexao);
		new ContrataFuncionario(repositorio).executa(funcionarioDTO);
		Assert.assertEquals("111.111.111-18", repositorio.buscaPorCpf("111.111.111-18").getCpf());
	}

}
