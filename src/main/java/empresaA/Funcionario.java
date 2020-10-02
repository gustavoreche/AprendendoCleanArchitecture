package empresaA;

import java.util.List;

public class Funcionario {
	
	private Cpf cpf;
	private String nome;
	private Email email;
	private List<Telefone> telefones;
	
	public void adicionaTelefone(String ddd, String numero) {
		this.telefones.add(new Telefone().insere(ddd, numero));
	}

}
