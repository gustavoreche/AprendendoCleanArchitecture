package empresaA.infraestrutura.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.dominio.util.Telefone;
import empresaA.infraestrutura.bancoDeDados.ConexaoComBancoDeDadosParaTestesComMock;
import empresaA.infraestrutura.util.exception.SalvaTelefoneException;

public class InsereTelefoneComJDBCComMockTeste extends ConexaoComBancoDeDadosParaTestesComMock {

	private static Funcionario funcionario;
	
	@BeforeClass
	public static void configuraMocks() {
		funcionario = Mockito.mock(Funcionario.class);
		List<Telefone> listaDeTelefone = new ArrayList<Telefone>();
		listaDeTelefone.add(Mockito.mock(Telefone.class));
		listaDeTelefone.add(Mockito.mock(Telefone.class));
		Mockito.doReturn(listaDeTelefone).when(funcionario).getTelefones();
	}
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void executa_tudoValido_retornoOk() {
		super.salvaNoBancoMock();
		Assert.assertTrue(new InsereTelefoneComJDBC(super.pegaConexao()).executa(funcionario));
	}
	
	@Test
	public void executa_tudoValidoMasNaoSalvaNoBanco_retornoOk() {
		Assert.assertFalse(new InsereTelefoneComJDBC(super.pegaConexao()).executa(funcionario));
	}

	@Test
	public void executa_semFuncionario_retornoException() {
		Assert.assertThrows(SalvaTelefoneException.class, () -> {
			new InsereTelefoneComJDBC(super.pegaConexao()).executa(null);
		});
	}

	@Test
	public void executa_semConexao_retornoException() {
		Assert.assertThrows(SalvaTelefoneException.class, () -> {
			new InsereTelefoneComJDBC(null).executa(funcionario);
		});
	}

}
