package empresaA.aplicacao.funcionario.contrata;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import empresaA.infraestrutura.bancoDeDados.ConexaoComMySQL;
import empresaA.infraestrutura.funcionario.RepositorioDeFuncionarioComJDBC;

public class ContrataFuncionarioTeste {
	
	private static Connection conexao = new ConexaoComMySQL().cria();
	
	@Test
	public void executa_tudoValido_retornoOk() {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO("111.111.111-18", 
				"Gustavo", "", "12", null);
		RepositorioDeFuncionarioComJDBC repositorio = new RepositorioDeFuncionarioComJDBC(conexao);
		new ContrataFuncionario(repositorio).executa(funcionarioDTO);
		Assert.assertEquals("111.111.111-18", repositorio.buscaPorCpf("111.111.111-18").getCpf());
	}

}
