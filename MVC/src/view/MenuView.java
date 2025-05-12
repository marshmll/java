package view;

import java.util.Scanner;

public class MenuView {
    private final Scanner scanner;

    public MenuView() {
        scanner = new Scanner(System.in);
    }

    public int opcoes() {
        System.out.println("*** MENU ***");
        System.out.println("[1] Cadastrar Usuário");
        System.out.println("[2] Listar Usuários");
        System.out.println("[9] Sair");
        System.out.print("Opção: ");

        return Integer.parseInt(scanner.nextLine());
    }

    public void opcaoInvalida() {
        System.out.println("Opção inválida, tente novamente.");
    }
}
