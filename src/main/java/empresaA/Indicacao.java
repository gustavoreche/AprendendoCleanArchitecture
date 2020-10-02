package empresaA;

public class Indicacao {
	
	private Funcionario indicado;
	private Funcionario quemIndicou;
	
	public Indicacao(Funcionario indicado, Funcionario quemIndicou) {
		this.indicado = indicado;
		this.quemIndicou = quemIndicou;
	}

}
