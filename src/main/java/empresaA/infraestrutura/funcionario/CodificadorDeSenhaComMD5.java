package empresaA.infraestrutura.funcionario;

import java.math.BigInteger;
import java.security.MessageDigest;

import empresaA.dominio.funcionario.servicos.CodificadorDeSenha;
import empresaA.infraestrutura.funcionario.exception.CodificaSenhaComMD5Exception;

public class CodificadorDeSenhaComMD5 implements CodificadorDeSenha {

	@Override
	public String codificaSenha(String senha) {
		MessageDigest tipoDeCodificacao;
		try {
			tipoDeCodificacao = MessageDigest.getInstance("MD5");
			tipoDeCodificacao.update(senha.getBytes(), 0, senha.length());
			return new BigInteger(1, tipoDeCodificacao.digest()).toString(16);
		} catch (Exception e) {
			throw new CodificaSenhaComMD5Exception();
		}
	}

	@Override
	public boolean validaSenha(String senhaCodificada, String senhaDigitada) {
		return senhaCodificada.equals(codificaSenha(senhaDigitada));
	}

}
