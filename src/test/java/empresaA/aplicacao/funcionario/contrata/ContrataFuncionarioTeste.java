package empresaA.aplicacao.funcionario.contrata;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import empresaA.infraestrutura.bancoDeDados.ConexaoComMySQL;
import empresaA.infraestrutura.funcionario.RepositorioDeFuncionarioComJDBC;

public class ContrataFuncionarioTeste {
	
	private static Connection conexao = new ConexaoComMySQL().cria();
	
	private static FuncionarioDTO funcionarioDTO;
	private static RepositorioDeFuncionarioComJDBC repositorio;
	
	@BeforeClass
	public static void limpaBanco() {
		funcionarioDTO = new FuncionarioDTO("111.111.111-18", "Gustavo", "", "12", null);
		repositorio = new RepositorioDeFuncionarioComJDBC(conexao);
		repositorio.demite(funcionarioDTO.criaFuncionario());
	}
	
	@Test
	public void executa_tudoValido_retornoOk() {
		new ContrataFuncionario(repositorio).executa(funcionarioDTO);
		Assert.assertEquals("111.111.111-18", repositorio.buscaPorCpf("111.111.111-18").getCpf());
	}

}
