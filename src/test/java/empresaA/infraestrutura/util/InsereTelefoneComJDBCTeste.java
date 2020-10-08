package empresaA.infraestrutura.util;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.dominio.funcionario.FuncionarioBuilder;
import empresaA.infraestrutura.conexaoComBanco.ConexaoComMySQL;
import empresaA.infraestrutura.funcionario.CodificadorDeSenhaComMD5;
import empresaA.infraestrutura.util.exception.SalvaTelefoneException;

public class InsereTelefoneComJDBCTeste {
	
	private static Connection conexao = new ConexaoComMySQL().cria();
	
	private Funcionario funcionario;
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		this.funcionario = new FuncionarioBuilder("111.111.111-18", "Gustavo", "1234", new CodificadorDeSenhaComMD5()).cria();
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
