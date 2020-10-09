package empresaA.infraestrutura.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.infraestrutura.bancoDeDados.ConexaoComBancoDeDadosParaTestesComMock;
import empresaA.infraestrutura.util.exception.DeletaTelefoneException;

public class DeletaTelefoneComJDBCComMockTeste extends ConexaoComBancoDeDadosParaTestesComMock {
	
	private static Funcionario funcionario;
	
	@BeforeClass
	public static void configuraMocks() {
		funcionario = Mockito.mock(Funcionario.class);
	}
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void executa_tudoValido_retornoOk() {
		Assert.assertTrue(new DeletaTelefoneComJDBC(super.pegaConexao()).executa(funcionario));
	}
	
	@Test
	public void executa_semFuncionario_retornoException() {
		Assert.assertThrows(DeletaTelefoneException.class, () -> {
			new DeletaTelefoneComJDBC(super.pegaConexao()).executa(null);
		});
	}
	
	@Test
	public void executa_semConexao_retornoException() {
		Assert.assertThrows(DeletaTelefoneException.class, () -> {
			new DeletaTelefoneComJDBC(null).executa(funcionario);
		});
	}

}
