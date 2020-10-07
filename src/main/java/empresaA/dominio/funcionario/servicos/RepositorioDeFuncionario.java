package empresaA.dominio.funcionario.servicos;

import java.util.List;

import empresaA.dominio.funcionario.Funcionario;

public interface RepositorioDeFuncionario {
	
	boolean contrata(Funcionario funcionario);
	
	boolean demite(Funcionario funcionario);
	
	Funcionario buscaPorCpf(String cpf);
	
	List<Funcionario> buscaTodosFuncionarios();

}
