package empresaA;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class FuncionarioBuilderComMockTeste {
	
	private String numeroCpf;
	private String nome;
	private String enderecoEmail;
	
	@Spy
	private FuncionarioBuilder funcionarioBuilder;
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		MockitoAnnotations.initMocks(this);

		String numeroCpf = "111.111.111-11";
		criaCpf(numeroCpf, numeroCpf);
		this.nome = "Gustavo";
		String enderecoEmail = "gustavo@teste.com";
		criaEmail(enderecoEmail, enderecoEmail);
	}
	
	private void criaCpf(String numeroCpf, String retornoCpf) {
		this.numeroCpf = numeroCpf;
		Mockito.doNothing().when(this.funcionarioBuilder).criaCpf(this.numeroCpf);
		Mockito.doReturn(retornoCpf).when(this.funcionarioBuilder).getNumeroCpf();
	}

	private void criaEmail(String enderecoEmail, String retornoEmail) {
		this.enderecoEmail = enderecoEmail;
		Mockito.doNothing().when(this.funcionarioBuilder).criaEmail(this.enderecoEmail);
		Mockito.doReturn(retornoEmail).when(this.funcionarioBuilder).getEnderecoEmail();
	}
	
	@Test
	public void constroi_cpfValido_retornoOk() {
		this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		Assert.assertEquals(this.numeroCpf, this.funcionarioBuilder.getNumeroCpf()); 
	}
	
	@Test
	public void constroi_emailValido_retornoOk() {
		this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		Assert.assertEquals(this.enderecoEmail, this.funcionarioBuilder.getEnderecoEmail()); 
	}
	
	@Test
	public void constroi_nomeValido_retornoOk() {
		this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		Assert.assertEquals(this.nome, this.funcionarioBuilder.getNome()); 
	}
	
	@Test
	public void constroi_cpfInvalido_retornoException() {
		criaCpf("111111111-11", null);
		this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		Assert.assertNull(this.funcionarioBuilder.getNumeroCpf());
	}
	
	@Test
	public void constroi_emailInvalido_retornoException() {
		criaEmail("gustavoteste.com", null);
		this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		Assert.assertNull(this.funcionarioBuilder.getEnderecoEmail());
	}
	
	@Test
	public void constroi_cpfVazio_retornoException() {
		criaCpf("", null);
		this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		Assert.assertNull(this.funcionarioBuilder.getNumeroCpf());
	}
	
	@Test
	public void constroi_emailVazio_retornoException() {
		criaEmail("", null);
		this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		Assert.assertNull(this.funcionarioBuilder.getEnderecoEmail());
	}

	@Test
	public void constroi_nomeVazio_retornoException() {
		Assert.assertThrows(NomeInvalidoException.class, () -> {
			this.nome = "";
			this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		});
	}

	@Test
	public void constroi_cpfNulo_retornoException() {
		criaCpf(null, null);
		this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		Assert.assertNull(this.funcionarioBuilder.getNumeroCpf());
	}
	
	@Test
	public void constroi_emailNulo_retornoException() {
		criaEmail(null, null);
		this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		Assert.assertNull(this.funcionarioBuilder.getEnderecoEmail());
	}
	
	@Test
	public void constroi_nomeNulo_retornoException() {
		Assert.assertThrows(NomeInvalidoException.class, () -> {
			this.nome = null;
			this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		});
	}
	
}
