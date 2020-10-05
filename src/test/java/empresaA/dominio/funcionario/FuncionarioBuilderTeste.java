package empresaA.dominio.funcionario;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import empresaA.dominio.funcionario.exception.NomeInvalidoException;
import empresaA.dominio.util.exception.CpfInvalidoException;
import empresaA.dominio.util.exception.EmailInvalidoException;
import empresaA.dominio.util.exception.TelefoneInvalidoException;
import empresaA.dominio.util.exception.TextoInvalidoException;

public class FuncionarioBuilderTeste {

	private String numeroCpf;
	private String nome;
	private String enderecoEmail;
	private String ddd;
	private String numeroTelefone;
	private FuncionarioBuilder funcionarioBuilder;
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		this.enderecoEmail = "gustavo@teste.com";
		this.numeroCpf = "111.111.111-11";
		this.nome = "Gustavo";
		this.ddd = "016";
		this.numeroTelefone = "11111-1111";
		this.funcionarioBuilder = new FuncionarioBuilder(this.numeroCpf, this.nome);
	}
	
	@Test
	public void criandoFuncionario_tudoValido_retornoOk() {
		Funcionario funcionario = this.funcionarioBuilder
			.adicionaEmail(this.enderecoEmail)
			.adicionaTelefone(this.ddd, this.numeroTelefone)
			.cria();
		Assert.assertEquals(this.numeroCpf, funcionario.getCpf().getNumero());
	}
	
	@Test
	public void criandoFuncionario_semEmail_retornoNull() {
		Funcionario funcionario = this.funcionarioBuilder.cria();
		Assert.assertNull(funcionario.getEmail());
	}
	
	@Test
	public void criandoFuncionario_semTelefone_retornoNull() {
		Funcionario funcionario = this.funcionarioBuilder.cria();
		Assert.assertEquals(new ArrayList<>(), funcionario.getTelefones());
	}
	
	@Test
	public void construtor_cpfValido_retornoOk() {
		Assert.assertEquals(this.numeroCpf, this.funcionarioBuilder.getNumeroCpf()); 
	}
	
	@Test
	public void construtor_nomeValido_retornoOk() {
		Assert.assertEquals(this.nome, this.funcionarioBuilder.getNome()); 
	}
	
	@Test
	public void construtor_cpfInvalido_retornoException() {
		Assert.assertThrows(CpfInvalidoException.class, () -> {
			this.numeroCpf = "111111111-11";
			new FuncionarioBuilder(this.numeroCpf, this.nome);
		});
	}
	
	@Test
	public void construtor_cpfVazio_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			this.numeroCpf = "";
			new FuncionarioBuilder(this.numeroCpf, this.nome);
		});
	}
	
	@Test
	public void construtor_nomeVazio_retornoException() {
		Assert.assertThrows(NomeInvalidoException.class, () -> {
			this.nome = "";
			new FuncionarioBuilder(this.numeroCpf, this.nome);
		});
	}
	
	@Test
	public void construtor_cpfNulo_retornoException() {
		Assert.assertThrows(CpfInvalidoException.class, () -> {
			this.numeroCpf = null;
			new FuncionarioBuilder(this.numeroCpf, this.nome);
		});
	}
	
	@Test
	public void construtor_nomeNulo_retornoException() {
		Assert.assertThrows(NomeInvalidoException.class, () -> {
			this.nome = null;
			new FuncionarioBuilder(this.numeroCpf, this.nome);
		});
	}
	
	@Test
	public void adicionaEmail_emailValido_retornoOk() {
		this.funcionarioBuilder.adicionaEmail(this.enderecoEmail);
		Assert.assertEquals(this.enderecoEmail, this.funcionarioBuilder.getEnderecoEmail()); 
	}
	
	@Test
	public void adicionaEmail_emailInvalido_retornoException() {
		Assert.assertThrows(EmailInvalidoException.class, () -> {
			this.enderecoEmail = "gustavoteste.com";
			this.funcionarioBuilder.adicionaEmail(this.enderecoEmail);
		});
	}
	
	@Test
	public void adicionaEmail_emailVazio_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			this.enderecoEmail = "";
			this.funcionarioBuilder.adicionaEmail(this.enderecoEmail);
		});
	}
	
	@Test
	public void adicionaEmail_emailNulo_retornoException() {
		Assert.assertThrows(EmailInvalidoException.class, () -> {
			this.enderecoEmail = null;
			this.funcionarioBuilder.adicionaEmail(this.enderecoEmail);
		});
	}
	
	@Test
	public void adicionaTelefone_dddValido_retornoOk() {
		this.funcionarioBuilder.adicionaTelefone(this.ddd, this.numeroTelefone);
		Assert.assertEquals(this.ddd, this.funcionarioBuilder.getDdd()); 
	}
	
	@Test
	public void adicionaTelefone_numeroValido_retornoOk() {
		this.funcionarioBuilder.adicionaTelefone(this.ddd, this.numeroTelefone);
		Assert.assertEquals(this.numeroTelefone, this.funcionarioBuilder.getNumeroTelefone()); 
	}
	
	@Test
	public void adicionaTelefone_dddInvalido_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			this.ddd = "16";
			this.funcionarioBuilder.adicionaTelefone(this.ddd, this.numeroTelefone);
		});
	}
	
	@Test
	public void adicionaTelefone_numeroInvalido_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			this.numeroTelefone = "11111-11111";
			this.funcionarioBuilder.adicionaTelefone(this.ddd, this.numeroTelefone);
		});
	}
	
	@Test
	public void adicionaTelefone_dddVazio_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			this.ddd = "";
			this.funcionarioBuilder.adicionaTelefone(this.ddd, this.numeroTelefone);
		});
	}
	
	@Test
	public void adicionaTelefone_numeroVazio_retornoException() {
		Assert.assertThrows(TextoInvalidoException.class, () -> {
			this.numeroTelefone = "";
			this.funcionarioBuilder.adicionaTelefone(this.ddd, this.numeroTelefone);
		});
	}
	
	@Test
	public void adicionaTelefone_dddNulo_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			this.ddd = null;
			this.funcionarioBuilder.adicionaTelefone(this.ddd, this.numeroTelefone);
		});
	}
	
	@Test
	public void adicionaTelefone_numeroNulo_retornoException() {
		Assert.assertThrows(TelefoneInvalidoException.class, () -> {
			this.numeroTelefone = null;
			this.funcionarioBuilder.adicionaTelefone(this.ddd, this.numeroTelefone);
		});
	}
	
}
