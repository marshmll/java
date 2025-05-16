package controller;

import view.ListaEventoPorDiaView;
import view.MenuView;

public class MenuController {
    private final MenuView mv;

    public MenuController() {
        mv = new MenuView();
    }

    public void run() {
        int option = 0;

        while (option != 9) {
            mv.showOptions();
            option = mv.getOption();

            if (option == 1) {
                ListaEventoController lvc = new ListaEventoController();
                lvc.run();
            } else if (option == 2) {
                ListaEventoPorDiaController ledc = new ListaEventoPorDiaController();
                ledc.run();
            } else if (option == 9) {
                mv.showExit();
                mv.closeScanner();
            } else {
                mv.showInvalidOption();
            }
        }
    }
}
