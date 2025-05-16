package view;

import java.util.Scanner;

public class MenuView {

    private final Scanner sc;

    public MenuView() {
        sc = new Scanner(System.in);
    }

    public void showOptions() {
        System.out.println("*** POLIWEEK ***");
        System.out.println("[1] Listar todos os eventos do ano de 2025");
        System.out.println("[2] Listar todos os eventos do ano de 2025 de quarta-feita");
        System.out.println("[9] Sair");
    }

    public int getOption() {
        System.out.print("Opção: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void showInvalidOption() {
        System.out.println("Opção inválda, tente novamente.");
    }

    public void showExit() {
        System.out.println("Saindo...");
    }

    public Scanner getScanner() {
        return sc;
    }

    public void closeScanner() {
        sc.close();
    }
}
