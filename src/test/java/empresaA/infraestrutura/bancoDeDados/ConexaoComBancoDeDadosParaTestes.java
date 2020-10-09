package empresaA.infraestrutura.bancoDeDados;

import java.sql.Connection;

import empresaA.dominio.conexaoComBanco.ConexaoComBancoDeDados;

public class ConexaoComBancoDeDadosParaTestes {
	
	ConexaoComBancoDeDados conexao;
	
	public ConexaoComBancoDeDadosParaTestes(ConexaoComBancoDeDados conexao) {
		this.conexao = conexao;
	}
	
	public ConexaoComBancoDeDadosParaTestes() {
		this.conexao = new ConexaoComMySQL();
	}
	
	protected Connection pegaConexao() {
		return this.conexao.cria();
	}

}
