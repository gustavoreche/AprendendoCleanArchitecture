package empresaA.infraestrutura.bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;

import empresaA.dominio.conexaoComBanco.ConexaoComBancoDeDados;
import empresaA.dominio.conexaoComBanco.exception.ErroDeConexaoException;

public class ConexaoComMySQL implements ConexaoComBancoDeDados {

	@Override
	public Connection cria() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/empresaA?useTimezone=true&serverTimezone=UTC", "root", "123456");			
		} catch (Exception e) {
			throw new ErroDeConexaoException(e.getMessage());
		}
	}

}
