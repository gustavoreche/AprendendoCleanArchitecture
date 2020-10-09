package empresaA.aplicacao.bancoDeDados;

import java.sql.Connection;

import empresaA.dominio.conexaoComBanco.ConexaoComBancoDeDados;

public class CriaConexaoComBancoDeDados {
	
	ConexaoComBancoDeDados conexao;
	
	public CriaConexaoComBancoDeDados(ConexaoComBancoDeDados conexao) {
		this.conexao = conexao;
	}
	
	public Connection pegaConexao() {
		return this.conexao.cria();
	}

}
