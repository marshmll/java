
public class Gato extends Animal {

	public Gato(String nome) {
		super(nome);
	}

	@Override
	void som() {
		System.out.println("Miau!");
	}
}
