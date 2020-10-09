package empresaA.infraestrutura.indicacao;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import empresaA.dominio.funcionario.Funcionario;
import empresaA.infraestrutura.indicacao.exception.EnviaEmailException;

public class EnviarEmailDeIndicacaoComJavaMailComMockTeste {
	
	private Funcionario funcionario;
	
	@Spy
	EnviarEmailDeIndicacaoComJavaMail enviaEmail;	
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		MockitoAnnotations.initMocks(this);
		try {
			this.funcionario = Mockito.mock(Funcionario.class);
			Mockito.doNothing().when(this.enviaEmail).enviaEmail(Matchers.any(Message.class));
			Mockito.doReturn("Gustavo").when(this.funcionario).getNome();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void enviaPara_tudoValido_retornoOk() {
		this.enviaEmail.enviaPara(this.funcionario);
		Assert.assertEquals(EnviarEmailDeIndicacaoComJavaMail.ASSUNTO_DO_EMAIL, this.enviaEmail.getAssunto());
	}
	
	@Test
	public void enviaPara_funcionarioNulo_retornoException() {
		Assert.assertThrows(EnviaEmailException.class, () -> {
			this.enviaEmail.enviaPara(null);
		});
	}

}
