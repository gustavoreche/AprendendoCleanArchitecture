package empresaA;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FuncionarioBuilderTeste {

	private String numeroCpf;
	private String nome;
	private String enderecoEmail;
	private FuncionarioBuilder funcionarioBuilder;
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		this.funcionarioBuilder = new FuncionarioBuilder();
		this.enderecoEmail = "gustavo@teste.com";
		this.numeroCpf = "111.111.111-11";
		this.nome = "Gustavo";
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
		Assert.assertThrows(CpfInvalidoException.class, () -> {
			this.numeroCpf = "111111111-11";
			this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		});
	}
	
	@Test
	public void constroi_emailInvalido_retornoException() {
		Assert.assertThrows(EmailInvalidoException.class, () -> {
			this.enderecoEmail = "gustavoteste.com";
			this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		});
	}
	
	@Test
	public void constroi_cpfVazio_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			this.numeroCpf = "";
			this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		});
	}
	
	@Test
	public void constroi_emailVazio_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			this.enderecoEmail = "";
			this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		});
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
		Assert.assertThrows(CpfInvalidoException.class, () -> {
			this.numeroCpf = null;
			this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		});
	}
	
	@Test
	public void constroi_emailNulo_retornoException() {
		Assert.assertThrows(EmailInvalidoException.class, () -> {
			this.enderecoEmail = null;
			this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		});
	}
	
	@Test
	public void constroi_nomeNulo_retornoException() {
		Assert.assertThrows(NomeInvalidoException.class, () -> {
			this.nome = null;
			this.funcionarioBuilder.constroi(this.numeroCpf, this.nome, this.enderecoEmail);
		});
	}
	
}
