import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] animaisAceitos = { "Gato", "Cachorro", "Abelha", "Galinha", "Bezerro" };
		ArrayList<Animal> animais = new ArrayList<>();

		System.out.println("***** CLÍNICA VETERINÁRIA *****");

		boolean sair = false;
		do {
			System.out.println("----- OPÇÕES -----");
			System.out.println("(1) Inserir novo animal para atendimento");
			System.out.println("(2) Sair ");

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
					String nomeAnimal = animaisAceitos[indexAnimal];
					System.out.println("Adicionando novo animal: " + animaisAceitos[indexAnimal]);

					try {
						Animal novoAnimal = (Animal) Class.forName(nomeAnimal).getConstructor().newInstance();
						animais.add(novoAnimal);

						System.out.println("Animal adicionado! Som: ");

						novoAnimal.som();
					} catch (Exception e) {
						System.out.println("Um erro ocorreu durante a instanciação da classe.");
					}
				}
			} else if (opcao == 2) {
				System.out.println("Saindo...");
				sair = true;
			} else {
				System.out.println("Opção inválida, tente novamente.");
			}
		} while (!sair);

		scanner.close();
	}
}
