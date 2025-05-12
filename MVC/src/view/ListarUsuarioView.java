package view;

import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class ListarUsuarioView {
    Scanner scanner;

    public ListarUsuarioView() {
        this.scanner = new Scanner(System.in);
    }

    public void listaUsuarios(ArrayList<Usuario> usuarios) {
        usuarios.forEach(usuario -> {
            System.out.println("-----------------------------------------");
            System.out.println("Usuario: " + usuario.getIdUsuario());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Senha: " + usuario.getSenha());
            System.out.println("Datahora: " + usuario.getDataHora());
        });
        System.out.println("-----------------------------------------");
    }
}
