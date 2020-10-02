package empresaA;

public class ValidadorPorExpressaoRegular {
	
	private String expressaoRegular;
	
	public ValidadorPorExpressaoRegular(String expressaoRegular) {
		if(expressaoRegular == null || expressaoRegular.isEmpty()) {
			throw new ExpressaoRegularInvalidaException();
		}
		this.expressaoRegular = expressaoRegular;
	}
	
	public boolean ehValido(String objetoParaValidar) {
		if(objetoParaValidar == null || objetoParaValidar.isEmpty()) {
			throw new TextoInvalidoException();
		}
		return objetoParaValidar.matches(this.expressaoRegular);
	}
	
	protected String getExpressaoRegular() {
		return expressaoRegular;
	}

}
