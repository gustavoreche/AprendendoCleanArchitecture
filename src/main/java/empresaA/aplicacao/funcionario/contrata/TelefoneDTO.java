package empresaA.aplicacao.funcionario.contrata;

public class TelefoneDTO {

	private String ddd;
	private String numero;

	public TelefoneDTO(String ddd, String numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public String getDdd() {
		return ddd;
	}
	
	public String getNumero() {
		return numero;
	}

}
