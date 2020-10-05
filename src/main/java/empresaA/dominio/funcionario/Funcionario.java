package empresaA.dominio.funcionario;

import java.util.List;

import empresaA.dominio.util.Cpf;
import empresaA.dominio.util.Email;
import empresaA.dominio.util.Telefone;

public class Funcionario {
	
	private Cpf cpf;
	private String nome;
	private Email email;
	private List<Telefone> telefones;
	
	protected Funcionario(FuncionarioBuilder funcionarioBuilder) {
		this.cpf = funcionarioBuilder.getCpf();
		this.nome = funcionarioBuilder.getNome();
		this.email = funcionarioBuilder.getEmail();
		this.telefones = funcionarioBuilder.getTelefones();
	}

	public Cpf getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Email getEmail() {
		return email;
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

}
