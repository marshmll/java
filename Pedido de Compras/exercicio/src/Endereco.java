
public class Endereco {
	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;
	private int numero;
	private String cep;

	public Endereco(String estado, String cidade, String bairro, String logradouro, int numero, String cep) {
		this.setEstado(estado);
		this.setCidade(cidade);
		this.setBairro(bairro);
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setCep(cep);
	}
	
	public final String getEnderecoCompleto() {
		return logradouro + ", " + numero + ". " + bairro + ", " + cidade + ", " + estado + ". " + cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
