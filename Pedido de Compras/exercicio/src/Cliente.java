public class Cliente {
	private String nome;
	private String telefone;
	private String cpf;
	private Endereco endereco;

	public Cliente(String nome, String telefone, String cpf, Endereco endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void exibirDados() {
		System.out.println("Cliente: " + nome + " | Telefone: " + telefone + " | CPF: " + cpf);
		System.out.println("Endereço: " + endereco.getEnderecoCompleto());
	}
}