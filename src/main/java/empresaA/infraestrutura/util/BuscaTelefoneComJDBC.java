package empresaA.infraestrutura.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import empresaA.infraestrutura.util.exception.BuscaTelefoneException;

public class BuscaTelefoneComJDBC {
	
	private Connection conexao;
	
	public BuscaTelefoneComJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	public Map<String, String> executa(String cpf) {
		int posicao = 1;
		Map<String, String> listaDeDddETelefone = new HashMap<>();
		String sql = "SELECT * FROM telefone WHERE cpf = ?";
		try(PreparedStatement statement = this.conexao.prepareStatement(sql)) {
			statement.setString(posicao++, cpf);
			ResultSet resultadoDaQuery = statement.executeQuery();
			while(resultadoDaQuery.next()) {
				posicao = 1;
				String ddd = resultadoDaQuery.getString(posicao++);
				String numero = resultadoDaQuery.getString(posicao++);
				listaDeDddETelefone.put(ddd, numero);
			}
		} catch (Exception e) {
			throw new BuscaTelefoneException(e.getMessage());
		}
		return listaDeDddETelefone;
	}
	
}
