package empresaA.infraestrutura.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.dominio.util.Telefone;
import empresaA.infraestrutura.util.exception.SalvaTelefoneException;

public class InsereTelefoneComJDBC implements AcaoTelefone {
	
	private Connection conexao;
	
	public InsereTelefoneComJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public boolean executa(Funcionario funcionario) {
		boolean sucesso = true;
		String sql = "INSERT INTO telefone VALUES (?, ?, ?)";
		try(PreparedStatement statement = this.conexao.prepareStatement(sql)) {
			for (Telefone telefone : funcionario.getTelefones()) {
				if(!sucesso) {
					return false;
				}
				int posicao = 1;
				statement.setString(posicao++, funcionario.getCpf());
				statement.setString(posicao++, telefone.getDdd());
				statement.setString(posicao++, telefone.getNumero());
				sucesso = insereNoBanco(statement);
			}
		} catch (Exception e) {
			throw new SalvaTelefoneException(e.getMessage());
		}
		return sucesso;
	}
	
	private boolean insereNoBanco(PreparedStatement statement) throws SQLException {
		return statement.executeUpdate() == 1;
	}

}
