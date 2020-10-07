package empresaA.infraestrutura.indicacao;

import org.junit.Test;

import empresaA.dominio.funcionario.FuncionarioBuilder;
import empresaA.infraestrutura.funcionario.CodificadorDeSenhaComMD5;

public class EnviarEmailDeIndicacaoComJavaMailTeste {
	
	@Test
	public void enviaPara_tudoValido_retornoOk() {
		new EnviarEmailDeIndicacaoComJavaMail().enviaPara(new FuncionarioBuilder("111.111.111-18", "Gustavo Reche", "1234", 
				new CodificadorDeSenhaComMD5()).cria());
	}

}
