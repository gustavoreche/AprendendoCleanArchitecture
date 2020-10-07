package empresaA;

import java.sql.Connection;
import java.sql.DriverManager;

import empresaA.aplicacao.funcionario.contrata.ContrataFuncionario;
import empresaA.infraestrutura.funcionario.RepositorioDeFuncionarioComJDBC;

public class Main {
	
	public static void main(String[] args) {
		new ContrataFuncionario(new RepositorioDeFuncionarioComJDBC(criaConexao()));
	}

	private static Connection criaConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager
					.getConnection("jdbc:mysql://localhost:3306/empresaA?useTimezone=true&serverTimezone=UTC", "root", "123456");			
		} catch (Exception e) {
			return null;
		}
	}

}
