package empresaA.infraestrutura.indicacao;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import empresaA.aplicacao.EnviarEmailDeIndicacao;
import empresaA.dominio.funcionario.Funcionario;
import empresaA.infraestrutura.indicacao.exception.EnviaEmailException;

public class EnviarEmailDeIndicacaoComJavaMail implements EnviarEmailDeIndicacao {
	
	private static final String EMAIL_PARA_ENVIAR = "seuamigo@teste.com";

	@Override
	public void enviaPara(Funcionario funcionario) {
		Session sessao = Session.getDefaultInstance(criaConfiguracaoDoServidorDeEmail(), insereDadosDoEmailQueEnviaraOsDados());
		sessao.setDebug(true);
		try {
			Transport.send(criaMensagemDeEmail(sessao, funcionario));
		} catch (Exception e) {
			throw new EnviaEmailException(e.getMessage());
		}
	}

	private Message criaMensagemDeEmail(Session sessao, Funcionario funcionario) throws MessagingException, AddressException {
		Message mensagem = new MimeMessage(sessao);
		mensagem.setFrom(new InternetAddress(ConfigurarEnviadorDeEmailJavaMail.EMAIL));

		Address[] toUser = InternetAddress.parse(EMAIL_PARA_ENVIAR);

		mensagem.setRecipients(Message.RecipientType.TO, toUser);
		mensagem.setSubject("Enviando email com JavaMail");
		mensagem.setText("Seja bem vindo " + funcionario.getNome());
		return mensagem;
	}

	private Authenticator insereDadosDoEmailQueEnviaraOsDados() {
		return new ConfigurarEnviadorDeEmailJavaMail();
	}

	private Properties criaConfiguracaoDoServidorDeEmail() {
		Properties configuracao = new Properties();
		configuracao.put("mail.smtp.host", "smtp.gmail.com");
		configuracao.put("mail.smtp.socketFactory.port", "465");
		configuracao.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		configuracao.put("mail.smtp.auth", "true");
		configuracao.put("mail.smtp.port", "465");
		return configuracao;
	}

}
