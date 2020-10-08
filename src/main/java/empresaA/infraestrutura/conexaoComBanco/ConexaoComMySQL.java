package empresaA.infraestrutura.conexaoComBanco;

import java.sql.Connection;
import java.sql.DriverManager;

import empresaA.dominio.conexaoComBanco.Conexao;
import empresaA.dominio.conexaoComBanco.exception.ErroDeConexaoException;

public class ConexaoComMySQL implements Conexao {

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
