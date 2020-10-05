package empresaA.infraestrutura.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.infraestrutura.util.exception.DeletaTelefoneException;

public class DeletaTelefoneComJDBC implements AcaoTelefone {

	private Connection conexao;
	
	public DeletaTelefoneComJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public boolean executa(Funcionario funcionario) {
		String sql = "DELETE FROM telefone WHERE cpf = ?";
		try (PreparedStatement statement = this.conexao.prepareStatement(sql)) {
			int posicao = 1;
			statement.setString(posicao++, funcionario.getCpf());
			return deletaDoBanco(statement);
		} catch (Exception e) {
			throw new DeletaTelefoneException(e.getMessage());
		}
	}

	protected boolean deletaDoBanco(PreparedStatement statement) throws SQLException {
		return statement.executeUpdate() == 1 || statement.executeUpdate() == 0;
	}

}
