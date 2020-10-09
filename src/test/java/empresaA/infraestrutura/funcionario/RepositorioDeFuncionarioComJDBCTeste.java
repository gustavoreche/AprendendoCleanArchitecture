package empresaA.infraestrutura.funcionario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.dominio.funcionario.FuncionarioBuilder;
import empresaA.infraestrutura.bancoDeDados.ConexaoComBancoDeDadosParaTestes;
import empresaA.infraestrutura.funcionario.exception.BuscaFuncionarioException;
import empresaA.infraestrutura.funcionario.exception.ContrataFuncionarioException;
import empresaA.infraestrutura.funcionario.exception.DemiteFuncionarioException;

public class RepositorioDeFuncionarioComJDBCTeste extends ConexaoComBancoDeDadosParaTestes {
	
	private RepositorioDeFuncionarioComJDBC repositorio;
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		this.repositorio = new RepositorioDeFuncionarioComJDBC(super.pegaConexao());		
	}
	
	@Test
	public void demite_tudoValido_retornoOk() {
		Assert.assertTrue(this.repositorio.demite(new FuncionarioBuilder("111.111.111-18", "Gustavo", "1234", new CodificadorDeSenhaComMD5()).cria()));
	}
	
	@Test
	public void demite_semFuncionario_retornoException() {
		Assert.assertThrows(DemiteFuncionarioException.class, () -> {
			this.repositorio.demite(null);
		});
	}
	
	@Test
	public void demite_semConexao_retornoException() {
		Assert.assertThrows(DemiteFuncionarioException.class, () -> {
			new RepositorioDeFuncionarioComJDBC(null).demite(null);
		});
	}
	
	@Test
	public void contrata_tudoValido_retornoOk() {
		Funcionario funcionario = new FuncionarioBuilder("111.111.111-18", "Gustavo", "1234", new CodificadorDeSenhaComMD5()).cria();
		this.repositorio.demite(funcionario);
		Assert.assertTrue(this.repositorio.contrata(funcionario));
	}
	
	@Test
	public void contrata_semFuncionario_retornoException() {
		Assert.assertThrows(ContrataFuncionarioException.class, () -> {
			this.repositorio.contrata(null);
		});
	}
	
	@Test
	public void contrata_semConexao_retornoException() {
		Assert.assertThrows(ContrataFuncionarioException.class, () -> {
			new RepositorioDeFuncionarioComJDBC(null).contrata(null);
		});
	}
	
	@Test
	public void buscaPorCpf_tudoValido_retornoOk() {
		Funcionario funcionario = new FuncionarioBuilder("111.111.111-18", "Gustavo", "1234", new CodificadorDeSenhaComMD5()).cria();
		this.repositorio.demite(funcionario);
		this.repositorio.contrata(funcionario);
		Assert.assertEquals(funcionario.getCpf(), this.repositorio.buscaPorCpf("111.111.111-18").getCpf());
	}
	
	@Test
	public void buscaPorCpf_semCpf_retornoException() {
		Assert.assertThrows(BuscaFuncionarioException.class, () -> {
			this.repositorio.buscaPorCpf(null);
		});
	}
	
	@Test
	public void buscaPorCpf_semConexao_retornoException() {
		Assert.assertThrows(BuscaFuncionarioException.class, () -> {
			new RepositorioDeFuncionarioComJDBC(null).buscaPorCpf(null);
		});
	}
	
	@Test
	public void buscaTodosFuncionarios_tudoValido_retornoOk() {
		Funcionario funcionario = new FuncionarioBuilder("111.111.111-18", "Gustavo", "1234", new CodificadorDeSenhaComMD5()).cria();
		this.repositorio.demite(funcionario);
		this.repositorio.contrata(funcionario);
		Assert.assertEquals(funcionario.getCpf(), this.repositorio.buscaTodosFuncionarios().get(0).getCpf());
	}
	
	@Test
	public void buscaTodosFuncionarios_semConexao_retornoException() {
		Assert.assertThrows(BuscaFuncionarioException.class, () -> {
			new RepositorioDeFuncionarioComJDBC(null).buscaTodosFuncionarios();
		});
	}
	
}
