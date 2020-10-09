package empresaA.infraestrutura.bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mockito.Matchers;
import org.mockito.Mockito;

public class ConexaoComBancoDeDadosParaTestesComMock {
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet resultadoDaQuery;
	
	public ConexaoComBancoDeDadosParaTestesComMock() {
		try {
			this.conexao = Mockito.mock(Connection.class);
			this.statement = Mockito.mock(PreparedStatement.class);
			this.resultadoDaQuery = Mockito.mock(ResultSet.class);
			Mockito.doReturn(this.statement).when(this.conexao).prepareStatement(Matchers.anyString());
			Mockito.doReturn(this.resultadoDaQuery).when(this.statement).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection pegaConexao() {
		return this.conexao;
	}

	protected void preencheObjetoMockado() {
		try {
			Mockito.doReturn(true).doReturn(false).when(this.resultadoDaQuery).next();
			Mockito.doReturn("123").when(this.resultadoDaQuery).getString(Matchers.anyInt());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void salvaNoBancoMock() {
		try {
			Mockito.doReturn(1).when(this.statement).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
