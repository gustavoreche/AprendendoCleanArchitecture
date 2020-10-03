package empresaA;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	
	private Cpf cpf;
	private String nome;
	private Email email;
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public Funcionario(String cpf, String nome, String email) {
		FuncionarioBuilder funcionarioBuilder = criaFuncionario(cpf, nome, email);
		this.cpf = funcionarioBuilder.getCpf();
		this.nome = funcionarioBuilder.getNome();
		this.email = funcionarioBuilder.getEmail();
	}

	private FuncionarioBuilder criaFuncionario(String cpf, String nome, String email) {
		return new FuncionarioBuilder().constroi(cpf, nome, email);
	}

	public void adicionaTelefone(String ddd, String numero) {
		this.telefones.add(new Telefone().insere(ddd, numero));
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
