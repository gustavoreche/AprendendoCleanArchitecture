package empresaA.infraestrutura.indicacao;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class ConfigurarEnviadorDeEmailJavaMail extends Authenticator {
	
	protected static final String EMAIL = "seuemail@teste.com.br";

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(EMAIL, "1111");
	}

}
