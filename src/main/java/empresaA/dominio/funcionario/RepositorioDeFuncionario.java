package empresaA.dominio.funcionario;

import java.util.List;

public interface RepositorioDeFuncionario {
	
	boolean contrata(Funcionario funcionario);
	
	boolean demite(Funcionario funcionario);
	
	Funcionario buscaPorCpf(String cpf);
	
	List<Funcionario> buscaTodosFuncionarios();

}
