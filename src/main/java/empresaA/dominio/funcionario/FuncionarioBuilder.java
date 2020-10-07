package empresaA.dominio.funcionario;

import java.util.ArrayList;
import java.util.List;

import empresaA.dominio.funcionario.exception.NomeInvalidoException;
import empresaA.dominio.funcionario.servicos.CodificadorDeSenha;
import empresaA.dominio.util.Cpf;
import empresaA.dominio.util.Email;
import empresaA.dominio.util.Senha;
import empresaA.dominio.util.Telefone;

public class FuncionarioBuilder {
	
	private Cpf cpf;
	private String nome;
	private Email email;
	private Senha senha;
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public FuncionarioBuilder(String cpf, String nome, String senha, CodificadorDeSenha codificadorDeSenha) {
		criaCpf(cpf);
		criaNome(nome);
		criaSenha(senha, codificadorDeSenha);
	}
	
	protected void criaCpf(String cpf) {
		this.cpf = new Cpf().insere(cpf);
	}
	
	protected void criaNome(String nome) {
		if(nome == null || nome.isEmpty())
			throw new NomeInvalidoException();
		this.nome = nome;
	}
	
	protected void criaSenha(String senha, CodificadorDeSenha codificadorDeSenha) {
		this.senha = new Senha(codificadorDeSenha).insere(senha);
	}
	
	public FuncionarioBuilder adicionaEmail(String email) {
		criaEmail(email);
		return this;
	}
	
	protected void criaEmail(String email) {
		this.email = new Email().insere(email);		
	}
	
	public FuncionarioBuilder adicionaTelefone(String ddd, String numero) {
		criaTelefone(ddd, numero);
		return this;
	}
	
	protected void criaTelefone(String ddd, String numero) {
		this.telefones.add(new Telefone().insere(ddd, numero));
	}
	
	public Funcionario cria() {
		return new Funcionario(this);
	}
	
	public Cpf getCpf() {
		return this.cpf;
	}
	
	protected String getNumeroCpf() {
		return this.cpf.getNumero();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Senha getSenha() {
		return this.senha;
	}
	
	protected String getSenhaCodificada() {
		return this.senha.getSenhaCodificada();
	}
	
	public Email getEmail() {
		return this.email;
	}
	
	protected String getEnderecoEmail() {
		return this.email.getEndereco();
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}
	
	protected String getDdd() {
		return telefones.get(0).getDdd();
	}
	
	protected String getNumeroTelefone() {
		return telefones.get(0).getNumero();
	}

}
