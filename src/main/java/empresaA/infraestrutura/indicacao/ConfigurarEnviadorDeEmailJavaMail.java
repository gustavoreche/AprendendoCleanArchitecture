package empresaA.infraestrutura.indicacao;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class ConfigurarEnviadorDeEmailJavaMail extends Authenticator {
	
	protected static final String EMAIL = "seuemail@teste.com.br";
	private static final String SENHA = "1111";

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(EMAIL, SENHA);
	}

}
