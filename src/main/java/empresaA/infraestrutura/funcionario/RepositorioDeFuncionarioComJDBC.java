package empresaA.infraestrutura.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.dominio.funcionario.RepositorioDeFuncionario;
import empresaA.infraestrutura.funcionario.exception.ContrataFuncionarioException;
import empresaA.infraestrutura.funcionario.exception.DemiteFuncionarioException;
import empresaA.infraestrutura.util.AcaoTelefone;
import empresaA.infraestrutura.util.DeletaTelefoneComJDBC;
import empresaA.infraestrutura.util.InsereTelefoneComJDBC;

public class RepositorioDeFuncionarioComJDBC implements RepositorioDeFuncionario {
	
	private Connection conexao;

	public RepositorioDeFuncionarioComJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public boolean contrata(Funcionario funcionario) {
		int posicao = 1;
		String sql = "INSERT INTO funcionario VALUES (?, ?, ?)";
		try(PreparedStatement statement = this.conexao.prepareStatement(sql)) {
			statement.setString(posicao++, funcionario.getCpf());
			statement.setString(posicao++, funcionario.getNome());
			statement.setString(posicao++, funcionario.getEmail());				
			if(!insereNoBanco(statement)) {
				return false;
			}
			return verificaSeTemTelefone(funcionario, new InsereTelefoneComJDBC(this.conexao));
		} catch (SQLException e) {
			throw new ContrataFuncionarioException(e.getMessage());
		}
	}

	private boolean insereNoBanco(PreparedStatement statement) throws SQLException {
		return statement.executeUpdate() == 1;
	}

	private boolean verificaSeTemTelefone(Funcionario funcionario, AcaoTelefone acaoTelefone) {
		if(funcionario.getTelefones() != null && !funcionario.getTelefones().isEmpty())
			return acaoTelefone.executa(funcionario);
		return true;
	}

	@Override
	public boolean demite(Funcionario funcionario) {
		int posicao = 1;
		String sql = "DELETE FROM funcionario WHERE cpf = ?";
		try(PreparedStatement statement = this.conexao.prepareStatement(sql)) {
			statement.setString(posicao++, funcionario.getCpf());
			if(!insereNoBanco(statement)) {
				return false;
			}
			return verificaSeTemTelefone(funcionario, new DeletaTelefoneComJDBC(this.conexao));
		} catch (SQLException e) {
			throw new DemiteFuncionarioException(e.getMessage());
		}
	}

	@Override
	public Funcionario buscaPorCpf(String cpf) {
		return null;
	}

	@Override
	public List<Funcionario> buscaTodosFuncionarios() {
		return null;
	}

}
