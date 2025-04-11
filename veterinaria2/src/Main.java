import java.security.SecureRandom;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] animaisAceitos = { "Gato", "Cachorro", "Abelha", "Galinha", "Bezerro" };
		ArrayList<Animal> animais = new ArrayList<>();
		SecureRandom rng = new SecureRandom();

		System.out.println("***** CLÍNICA VETERINÁRIA *****");

		boolean sair = false;
		do {
			System.out.println("----- OPÇÕES -----");
			System.out.println("(1) Inserir novo animal para atendimento");
			System.out.println("(2) Mostrar animais cadastrados");
			System.out.println("(9) Sair ");

			System.out.print("OPÇÃO: ");

			int opcao = Integer.parseInt(scanner.nextLine());

			if (opcao == 1) {
				System.out.println("---- ANIMAIS ACEITOS ----");

				for (int i = 0; i < animaisAceitos.length; i++) {
					System.out.println("(" + (i + 1) + ") " + animaisAceitos[i]);
				}

				System.out.print("Digite a sua escolha: ");
				int indexAnimal = Integer.parseInt(scanner.nextLine()) - 1;

				if (indexAnimal < 0 || indexAnimal >= animaisAceitos.length) {
					System.out.println("Opção inváida, tente novamente!");
				} else {
					System.out.print("Digite o nome do animal: ");
					String nome = scanner.nextLine();

					String classAnimal = animaisAceitos[indexAnimal];
					System.out.println("Adicionando novo animal: " + animaisAceitos[indexAnimal] + " com nome: " + nome);

					try {
						Animal novoAnimal = (Animal) Class.forName(classAnimal).getConstructor(String.class).newInstance(nome);
						animais.add(novoAnimal);

						System.out.println("\"" + nome + "\" adicionado(a)! Som: ");
						novoAnimal.som(rng.nextInt(10));
					} catch (Exception e) {
						System.out.println("Um erro ocorreu durante a instanciação da classe.");
					}
				}
			} else if (opcao == 2) {

				if (animais.isEmpty()) {
					System.out.println("A lista de animais está vazia.");
				} else {
					System.out.println("----- ANIMAIS ADICIONADOS -----");
					for (int i = 0; i < animais.size(); i++) {
						System.out.println("(" + (i + 1) + ") " + animais.get(i).getClass().getSimpleName() + " com nome \"" + animais.get(i).getNome() + "\"");
					}
				}
			} else if (opcao == 9) {
				System.out.println("Saindo...");
				sair = true;
			} else {
				System.out.println("Opção inválida, tente novamente.");
			}
		} while (!sair);

		scanner.close();
	}
}
