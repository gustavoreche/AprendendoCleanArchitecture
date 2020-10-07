package empresaA.aplicacao.funcionario.contrata;

import java.util.List;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.dominio.funcionario.FuncionarioBuilder;
import empresaA.infraestrutura.funcionario.CodificadorDeSenhaComMD5;

public class FuncionarioDTO {

	private String cpf;
	private String nome;
	private String email;
	private String senha;
	private List<TelefoneDTO> telefones;

	public FuncionarioDTO(String cpf, String nome, String email, String senha, List<TelefoneDTO> telefones) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefones = telefones;
	}
	
	public Funcionario criaFuncionario() {
		FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder(this.cpf, this.nome, this.senha, new CodificadorDeSenhaComMD5());
		if(this.email != null && !this.email.isEmpty()) {
			funcionarioBuilder.adicionaEmail(this.email);
		}
		if(this.telefones != null && !this.telefones.isEmpty()) {
			for (TelefoneDTO telefone : telefones) {
				funcionarioBuilder.adicionaTelefone(telefone.getDdd(), telefone.getNumero());				
			}
		}		
		return funcionarioBuilder.cria();
	}

}
