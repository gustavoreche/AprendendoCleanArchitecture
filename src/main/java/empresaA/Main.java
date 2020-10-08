package empresaA;

import java.sql.Connection;

import empresaA.aplicacao.funcionario.contrata.ContrataFuncionario;
import empresaA.dominio.conexaoComBanco.Conexao;
import empresaA.infraestrutura.conexaoComBanco.ConexaoComMySQL;
import empresaA.infraestrutura.funcionario.RepositorioDeFuncionarioComJDBC;

public class Main {
	
	public static void main(String[] args) {
		new ContrataFuncionario(new RepositorioDeFuncionarioComJDBC(criaConexao(new ConexaoComMySQL())));
	}

	private static Connection criaConexao(Conexao conexao) {
		return conexao.cria();
	}

}
