package empresaA.infraestrutura.funcionario;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.dominio.funcionario.FuncionarioBuilder;
import empresaA.dominio.funcionario.servicos.CodificadorDeSenha;
import empresaA.dominio.util.Telefone;
import empresaA.infraestrutura.bancoDeDados.ConexaoComBancoDeDadosParaTestesComMock;
import empresaA.infraestrutura.bancoDeDados.EnumSalvaNoBanco;
import empresaA.infraestrutura.funcionario.exception.BuscaFuncionarioException;
import empresaA.infraestrutura.funcionario.exception.ContrataFuncionarioException;
import empresaA.infraestrutura.funcionario.exception.DemiteFuncionarioException;
import empresaA.infraestrutura.util.EnumAcaoTelefone;
import empresaA.infraestrutura.util.InsereTelefoneComJDBC;

public class RepositorioDeFuncionarioComJDBCComMockTeste extends ConexaoComBancoDeDadosParaTestesComMock {
	
	@Spy
	private RepositorioDeFuncionarioComJDBC repositorioMock;

	private RepositorioDeFuncionarioComJDBC repositorio;
	
	private Funcionario funcionario;
	private FuncionarioBuilder funcionarioBuilder;

	@Before
	public void iniciaAntesDeCadaTeste() {
		MockitoAnnotations.initMocks(this);
		this.funcionario = Mockito.mock(Funcionario.class);
		this.funcionarioBuilder = Mockito.mock(FuncionarioBuilder.class);
		this.repositorio = new RepositorioDeFuncionarioComJDBC(super.pegaConexao());		
	}
	
	@Test
	public void demite_tudoValido_retornoOk() {
		Assert.assertTrue(this.repositorio.demite(this.funcionario));
	}
	
	@Test
	public void demite_tudoValidoNaoPersisteNoBanco_retornoOk() {
		super.salvaNoBancoMock(EnumSalvaNoBanco.NAO_PERSISTE);
		Assert.assertFalse(this.repositorio.demite(this.funcionario));
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
		super.salvaNoBancoMock(EnumSalvaNoBanco.PERSISTE);
		Assert.assertTrue(this.repositorio.contrata(this.funcionario));
	}
	
	@Test
	public void contrata_tudoValidoComTelefone_retornoOk() {
		super.salvaNoBancoMock(EnumSalvaNoBanco.PERSISTE);
		Mockito.doReturn(super.pegaConexao()).when(this.repositorioMock).pegaConexao();
		InsereTelefoneComJDBC insereMock = Mockito.mock(InsereTelefoneComJDBC.class);
		Mockito.doReturn(insereMock).when(this.repositorioMock).defineAcaoTelefone(EnumAcaoTelefone.INSERE);
		Mockito.doReturn(true).when(insereMock).executa(this.funcionario);
		List<Telefone> listaDeTelefone = new ArrayList<Telefone>();
		listaDeTelefone.add(Mockito.mock(Telefone.class));
		listaDeTelefone.add(Mockito.mock(Telefone.class));
		Mockito.doReturn(listaDeTelefone).when(this.funcionario).getTelefones();
		Assert.assertTrue(this.repositorioMock.contrata(this.funcionario));
	}
	
	@Test
	public void contrata_tudoValidoMasNaoSalvaNoBanco_retornoOk() {
		Assert.assertFalse(this.repositorio.contrata(this.funcionario));
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
		preencheObjetoMockado();
		Mockito.doReturn(this.funcionarioBuilder).when(this.repositorioMock).criaFuncionario(Matchers.anyString(), Matchers.anyString(), Matchers.anyString(), 
				Matchers.anyString(), Matchers.anyString(), Matchers.any(CodificadorDeSenha.class));
		Mockito.doReturn(this.funcionario).when(this.funcionarioBuilder).cria();
		Mockito.doReturn(super.pegaConexao()).when(this.repositorioMock).pegaConexao();
		Assert.assertEquals(funcionario.getCpf(), this.repositorioMock.buscaPorCpf("111.111.111-18").getCpf());
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
		super.preencheObjetoMockado();
		Mockito.doReturn(this.funcionarioBuilder).when(this.repositorioMock).criaFuncionario(Matchers.anyString(), Matchers.anyString(), Matchers.anyString(), 
				Matchers.anyString(), Matchers.anyString(), Matchers.any(CodificadorDeSenha.class));
		Mockito.doReturn(this.funcionario).when(this.funcionarioBuilder).cria();
		Mockito.doReturn(super.pegaConexao()).when(this.repositorioMock).pegaConexao();
		Assert.assertEquals(funcionario.getCpf(), this.repositorioMock.buscaTodosFuncionarios().get(0).getCpf());
	}
	
	@Test
	public void buscaTodosFuncionarios_semConexao_retornoException() {
		Assert.assertThrows(BuscaFuncionarioException.class, () -> {
			new RepositorioDeFuncionarioComJDBC(null).buscaTodosFuncionarios();
		});
	}

}
