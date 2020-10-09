package empresaA.infraestrutura.indicacao;

import org.junit.Assert;
import org.junit.Test;

import empresaA.dominio.funcionario.FuncionarioBuilder;
import empresaA.infraestrutura.funcionario.CodificadorDeSenhaComMD5;
import empresaA.infraestrutura.indicacao.exception.EnviaEmailException;

public class EnviarEmailDeIndicacaoComJavaMailTeste {
	
	/*
	 * TODO: Para este teste passar, deve ser realizada as configurações abaixo:
	 *
	 *  - classe: EnviarEmailDeIndicacaoComJavaMail -> na variável EMAIL_PARA_ENVIAR, colocar um email válido;(email para quem será ENVIADO);
	 *  - classe: ConfigurarEnviadorDeEmailJavaMail -> na variável EMAIL, colocar um email válido;(email de quem irá ENVIAR);
	 *  											-> na variável SENHA, colocar a senha do email acima, ou seja, da variável EMAIL;
	 */
	@Test
	public void enviaPara_tudoValido_retornoOk() {
		EnviarEmailDeIndicacaoComJavaMail enviarEmailDeIndicacaoComJavaMail = new EnviarEmailDeIndicacaoComJavaMail();
		enviarEmailDeIndicacaoComJavaMail.enviaPara(new FuncionarioBuilder("111.111.111-18", "Gustavo Reche", "1234", 
				new CodificadorDeSenhaComMD5()).cria());
		Assert.assertEquals(EnviarEmailDeIndicacaoComJavaMail.ASSUNTO_DO_EMAIL, enviarEmailDeIndicacaoComJavaMail.getAssunto());
	}
	
	@Test
	public void enviaPara_funcionarioNulo_retornoException() {
		Assert.assertThrows(EnviaEmailException.class, () -> {
			new EnviarEmailDeIndicacaoComJavaMail().enviaPara(null);
		});
	}

}
