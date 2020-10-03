package empresaA;

public class FuncionarioBuilder {
	
	private Cpf cpf;
	private String nome;
	private Email email;
	
	public FuncionarioBuilder constroi(String cpf, String nome, String email) {
		criaCpf(cpf);
		criaNome(nome);
		criaEmail(email);
		return this;
	}
	
	protected void criaCpf(String cpf) {
		this.cpf = new Cpf().insere(cpf);
	}
	
	protected void criaEmail(String email) {
		this.email = new Email().insere(email);		
	}
	
	protected void criaNome(String nome) {
		if(nome == null || nome.isEmpty())
			throw new NomeInvalidoException();
		this.nome = nome;
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
	
	public Email getEmail() {
		return this.email;
	}
	
	protected String getEnderecoEmail() {
		return this.email.getEndereco();
	}

}
