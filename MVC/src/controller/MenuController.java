package controller;

import view.MenuView;

public class MenuController {

    public MenuController() {
        MenuView menuView = new MenuView();
        int opcao = 0;

        while (opcao != 9) {
            opcao = menuView.opcoes();

            if (opcao == 1) {
                new CadastrarUsuarioController();
            }
            else if (opcao == 2) {
                new ListarUsuarioController();
            }
            else if (opcao == 9) {
                System.out.println("Saindo...");
            }
            else {
                menuView.opcaoInvalida();
            }
        }
    }
}
