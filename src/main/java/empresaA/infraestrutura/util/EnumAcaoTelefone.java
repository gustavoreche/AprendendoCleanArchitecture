package empresaA.infraestrutura.util;

import java.sql.Connection;

public enum EnumAcaoTelefone {

	INSERE(),
	DELETA(),
	;
	
	public AcaoTelefone pegaAcao(EnumAcaoTelefone enumAcao, Connection conexao) {
		for (EnumAcaoTelefone acao : EnumAcaoTelefone.values()) {
			switch (acao) {
			case INSERE:
				return new InsereTelefoneComJDBC(conexao);
			case DELETA:
				return new DeletaTelefoneComJDBC(conexao);
			default:
				return null;
			}
		}
		return null;
	}
	
}
