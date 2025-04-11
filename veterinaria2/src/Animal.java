
public abstract class Animal {
	protected String nome;

	protected Animal(String nome) {
		this.nome = nome;
	}

	abstract void som();
	protected void som(final int reps) { for (int i = 0; i < reps; i++) som(); }
	protected final String getNome() { return nome; }
}
