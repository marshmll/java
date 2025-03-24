
public final class Validador {
	private final static String cpfRegex = "^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}";
	private final static String cepRegex = "^[0-9]{5}-[0-9]{3}";

	private Validador() {
	}

	public static final boolean cpfValido(String cpf) {
		return cpf != null && cpf.matches(cpfRegex);
	}
	
	public static final boolean cepValido(String cep) {
		return cep != null && cep.matches(cepRegex);
	}
}
