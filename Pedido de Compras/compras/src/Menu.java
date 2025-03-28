import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final Restaurante restaurante;
    private final Scanner scanner;
    private Cliente cliente;
    private Pedido pedido;

    public Menu(Restaurante restaurante) {
        this.restaurante = restaurante;
        this.scanner = new Scanner(System.in);
    }

    public void cadastrarPedido() {
        this.pedido = new Pedido(this.cliente);

        boolean continuar = true;
        while (continuar) {
            this.restaurante.listarPratos();
            mostrarOpcoes();

            System.out.print("OPÇÃO: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                this.pedido.exibirPedido();

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
            } else if (opcao == 2) {
                this.pedido.exibirPedido();

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

                        System.out.print("Qual dos pedidos você deseja remover? (1 à " + pratosComMesmoCodigo.size() + "): ");

                        int opcaoPedido = Integer.parseInt(scanner.nextLine()) - 1;

                        if (opcaoPedido >= 0 && opcaoPedido < pratosComMesmoCodigo.size()) {
                            pedido.removerPratoInstanciaN(codigoPratoRemover, opcaoPedido);
                            System.out.println("Pedido atualizado:");
                            pedido.exibirPedido();
                        } else {
                            System.out.println("Pedido inválido, tente novamente.");
                        }
                    }

                    pedido.exibirPedido();
                }
            } else if (opcao == 3) {
                continuar = false;
                pedido.exibirPedido();
            }
            else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public void encerrar() {
        this.scanner.close();
    }

    public void cadastrarCliente() {
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
        this.cliente = new Cliente(nomeCliente, telefoneCliente, cpfCliente, enderecoCliente);
    }

    public void mostrarOpcoes() {
        System.out.println("*******MENU********");
        System.out.println();
        System.out.println("(1) Adicionar Prato");
        System.out.println("(2) Remover Prato");
        System.out.println("(3) Encerrar");
    }
}
