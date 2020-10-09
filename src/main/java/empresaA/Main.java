package empresaA;

import java.sql.Connection;

import empresaA.aplicacao.bancoDeDados.CriaConexaoComBancoDeDados;
import empresaA.aplicacao.funcionario.contrata.ContrataFuncionario;
import empresaA.infraestrutura.bancoDeDados.ConexaoComMySQL;
import empresaA.infraestrutura.funcionario.RepositorioDeFuncionarioComJDBC;

public class Main {
	
	public static void main(String[] args) {
		new ContrataFuncionario(new RepositorioDeFuncionarioComJDBC(criaConexao()));
	}

	private static Connection criaConexao() {
		return new CriaConexaoComBancoDeDados(new ConexaoComMySQL()).pegaConexao();
	}

}
