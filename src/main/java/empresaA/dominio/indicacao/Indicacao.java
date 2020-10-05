package empresaA.dominio.indicacao;

import java.time.LocalDateTime;

import empresaA.dominio.funcionario.Funcionario;

public class Indicacao {
	
	private Funcionario indicado;
	private Funcionario quemIndicou;
	private LocalDateTime dataIndicacao;
	
	public Indicacao(Funcionario indicado, Funcionario quemIndicou) {
		this.indicado = indicado;
		this.quemIndicou = quemIndicou;
		this.dataIndicacao = LocalDateTime.now();
	}

	public Funcionario getIndicado() {
		return indicado;
	}

	public Funcionario getQuemIndicou() {
		return quemIndicou;
	}

	public LocalDateTime getDataIndicacao() {
		return dataIndicacao;
	}
	
}
