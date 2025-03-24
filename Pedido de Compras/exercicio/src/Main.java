import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Restaurante restaurante = new Restaurante("Restaurante BCC");

		restaurante.adicionarPratoAoMenu(new Prato(1, "Lasanha", 35.0));
		restaurante.adicionarPratoAoMenu(new Prato(2, "Feijoada", 50.0));
		restaurante.adicionarPratoAoMenu(new Prato(3, "Pizza", 60.0));
		restaurante.adicionarPratoAoMenu(new Prato(4, "Hambúrguer", 25.0));
		restaurante.adicionarPratoAoMenu(new Prato(5, "Arroz", 20.0));
		restaurante.adicionarPratoAoMenu(new Prato(6, "Salada", 15.0));

		System.out.println("*** CADASTRAR CLIENTE ***");
		System.out.print("Nome: ");
		String nomeCliente = scanner.nextLine();

		System.out.print("Telefone: ");
		String telefoneCliente = scanner.nextLine();

		boolean cpfValido = false;
		String cpfCliente = "";

		while (!cpfValido) {
			System.out.print("CPF (xxx.xxx.xxx-xx): ");
			cpfCliente = scanner.nextLine();

			cpfValido = Validador.cpfValido(cpfCliente);

			if (!cpfValido)
				System.out.println("CPF inválido, por favor, insira no formato correto.");
		}

		System.out.print("(Endereço) Estado: ");
		String estado = scanner.nextLine();

		System.out.print("(Endereço) Cidade: ");
		String cidade = scanner.nextLine();

		System.out.print("(Endereço) Bairro: ");
		String bairro = scanner.nextLine();

		System.out.print("(Endereço) Logradouro/rua: ");
		String logradouro = scanner.nextLine();

		System.out.print("(Endereço) Número: ");
		int numero = Integer.parseInt(scanner.nextLine());

		boolean cepValido = false;
		String cep = "";

		while (!cepValido) {
			System.out.print("(Endereço) CEP (xxxxx-xxx): ");
			cep = scanner.nextLine();

			cepValido = Validador.cepValido(cep);

			if (!cepValido)
				System.out.println("CEP inválido, por favor, insira no formato correto.");
		}

		Endereco enderecoCliente = new Endereco(estado, cidade, bairro, logradouro, numero, cep);

		Cliente cliente = new Cliente(nomeCliente, telefoneCliente, cpfCliente, enderecoCliente);

		Pedido pedido = new Pedido(cliente);

		restaurante.listarPratos();

		boolean continuar = true;
		while (continuar) {
			System.out.print("\nDigite o código da prato desejado: ");
			int codigoPrato = scanner.nextInt();
			scanner.nextLine();
			Prato prato = restaurante.buscarPrato(codigoPrato);
			if (prato != null) {
				pedido.adicionarPrato(prato);
			} else {
				System.out.println("\nPrato não encontrado, tente novamente.");
			}

			pedido.exibirPedido();

			System.out.print("Deseja remover algum prato? (s/n): ");
			String resposta = scanner.nextLine();
			if (resposta.equalsIgnoreCase("s")) {
				System.out.print("Digite o código do prato a remover: ");
				int codigoPratoRemover = scanner.nextInt();
				scanner.nextLine();

				ArrayList<Prato> pratosComMesmoCodigo = new ArrayList<Prato>(pedido.listarPratos(codigoPratoRemover));

				if (pratosComMesmoCodigo.isEmpty()) {
					System.out.println("Nenhum prato com código " + codigoPratoRemover + " foi pedido.");
				} else {
					Prato pratoAremover = restaurante.buscarPrato(codigoPratoRemover);

					System.out.println("--------Prato a remover--------");
					pratoAremover.exibirDetalhes();

					if (pratosComMesmoCodigo.size() == 1) {
						System.out.println("Removendo prato...");
						pedido.removerPrato(codigoPratoRemover);
						pedido.exibirPedido();
					} else {
						System.out.println("Foram feitas " + pratosComMesmoCodigo.size()
								+ " ordens de pedido para o prato selecionado");

						System.out.print(
								"Qual dos pedidos você deseja remover? (1 à " + pratosComMesmoCodigo.size() + "): ");
						int opcao = Integer.parseInt(scanner.nextLine()) - 1;

						if (opcao >= 0 && opcao < pratosComMesmoCodigo.size()) {
							pedido.removerPratoInstanciaN(codigoPratoRemover, opcao);
							System.out.println("Pedido atualizado:");
							pedido.exibirPedido();
						} else {
							System.out.println("Pedido inválido, tente novamente.");
						}
					}
				}
			}

			System.out.print("Deseja encerrar? (s/n): ");
			String respostaEncerrar = scanner.nextLine();
			if (respostaEncerrar.equalsIgnoreCase("s")) {
				continuar = false;
			}
		}

		pedido.exibirPedido();
		scanner.close();
	}
}