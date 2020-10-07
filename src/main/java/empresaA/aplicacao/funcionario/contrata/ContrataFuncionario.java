package empresaA.aplicacao.funcionario.contrata;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.dominio.funcionario.servicos.RepositorioDeFuncionario;

public class ContrataFuncionario {
	
	RepositorioDeFuncionario repositorio;
	
	public ContrataFuncionario(RepositorioDeFuncionario repositorio) {
		this.repositorio = repositorio;
	}
	
	public void executa(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = funcionarioDTO.criaFuncionario();
		this.repositorio.contrata(funcionario);
	}

}
