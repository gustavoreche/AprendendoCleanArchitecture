package empresaA.infraestrutura.bancoDeDados;

public enum EnumSalvaNoBanco {
	
	PERSISTE_MAS_NAO_ALTERA(0),
	PERSISTE(1),
	NAO_PERSISTE(99),
	;
	
	private int codigo;

	private EnumSalvaNoBanco(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
}
