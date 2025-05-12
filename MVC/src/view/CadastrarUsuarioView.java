package view;

import model.Usuario;

import java.util.Scanner;

public class CadastrarUsuarioView {
    private Scanner scanner;

    public CadastrarUsuarioView() {
        scanner = new Scanner(System.in);
    }

    public Usuario cadastrarUsuario() {
        System.out.println("*** CADASTRAR USUÁRIO ***");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        return new Usuario(email, senha);
    }

    public void cadastroSucesso() {
        System.out.println("Usuário cadastrado com sucesso!");
    }
}
