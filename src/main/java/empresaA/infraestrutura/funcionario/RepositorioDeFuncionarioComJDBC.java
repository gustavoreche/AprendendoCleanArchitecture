package empresaA.infraestrutura.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.dominio.funcionario.FuncionarioBuilder;
import empresaA.dominio.funcionario.servicos.RepositorioDeFuncionario;
import empresaA.infraestrutura.funcionario.exception.BuscaFuncionarioException;
import empresaA.infraestrutura.funcionario.exception.ContrataFuncionarioException;
import empresaA.infraestrutura.funcionario.exception.DemiteFuncionarioException;
import empresaA.infraestrutura.util.AcaoTelefone;
import empresaA.infraestrutura.util.BuscaTelefoneComJDBC;
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
		StringBuilder sql = new StringBuilder("INSERT INTO funcionario VALUES (?, ?, ?)");
		try(PreparedStatement statement = this.conexao.prepareStatement(sql.toString())) {
			statement.setString(posicao++, funcionario.getCpf());
			statement.setString(posicao++, funcionario.getNome());
			statement.setString(posicao++, funcionario.getEmail());								
			if(!insereNoBanco(statement)) {
				return false;
			}
			return verificaSeTemTelefone(funcionario, new InsereTelefoneComJDBC(this.conexao));
		} catch (Exception e) {
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
			if(!deletaNoBanco(statement)) {
				return false;
			}
			return verificaSeTemTelefone(funcionario, new DeletaTelefoneComJDBC(this.conexao));
		} catch (Exception e) {
			throw new DemiteFuncionarioException(e.getMessage());
		}
	}
	
	private boolean deletaNoBanco(PreparedStatement statement) throws SQLException {
		return statement.executeUpdate() == 1 || statement.executeUpdate() == 0;
	}

	@Override
	public Funcionario buscaPorCpf(String cpf) {
		int posicao = 1;
		String sql = "SELECT * FROM funcionario WHERE cpf = ?";
		try(PreparedStatement statement = this.conexao.prepareStatement(sql)) {
			statement.setString(posicao++, cpf);
			ResultSet resultadoDaQuery = statement.executeQuery();
			if(!resultadoDaQuery.next()) {
				throw new BuscaFuncionarioException(cpf);
			}
			posicao = 1;
			String cpfDoBanco = resultadoDaQuery.getString(posicao++);
			String nome = resultadoDaQuery.getString(posicao++);
			String email = resultadoDaQuery.getString(posicao++);
			FuncionarioBuilder funcionarioBuilder = criaFuncionario(cpf, cpfDoBanco, nome, email);
			return funcionarioBuilder.cria();
		} catch (Exception e) {
			throw new BuscaFuncionarioException(cpf, e.getMessage());
		}
	}

	private FuncionarioBuilder criaFuncionario(String cpf, String cpfDoBanco, String nome, String email) {
		FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder(cpfDoBanco, nome);
		if(!email.isEmpty()) {
			funcionarioBuilder.adicionaEmail(email);
		}
		Map<String, String> listaDeDddETelefone = new BuscaTelefoneComJDBC(this.conexao).executa(cpf);
		if(!listaDeDddETelefone.isEmpty()) {
			for (Entry<String, String> dddENumero : listaDeDddETelefone.entrySet()) {
				String ddd = dddENumero.getKey();
				String numero = dddENumero.getValue();
				funcionarioBuilder.adicionaTelefone(ddd, numero);
			}			
		}
		return funcionarioBuilder;
	}

	@Override
	public List<Funcionario> buscaTodosFuncionarios() {
		int posicao = 1;
		List<Funcionario> listaDeFuncionario = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM funcionario";
		try(PreparedStatement statement = this.conexao.prepareStatement(sql)) {
			ResultSet resultadoDaQuery = statement.executeQuery();
			while(resultadoDaQuery.next()) {
				posicao = 1;
				String cpfDoBanco = resultadoDaQuery.getString(posicao++);
				String nome = resultadoDaQuery.getString(posicao++);
				String email = resultadoDaQuery.getString(posicao++);
				FuncionarioBuilder funcionarioBuilder = criaFuncionario(cpfDoBanco, cpfDoBanco, nome, email);
				listaDeFuncionario.add(funcionarioBuilder.cria());				
			}
			return listaDeFuncionario;
		} catch (Exception e) {
			throw new BuscaFuncionarioException(e.getMessage());
		}
	}

}
