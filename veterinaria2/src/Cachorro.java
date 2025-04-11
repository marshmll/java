
public class Cachorro extends Animal {

	public Cachorro(String nome) {
		super(nome);
	}

	@Override
	void som() {
		System.out.println("Au, au!");
	}
}
