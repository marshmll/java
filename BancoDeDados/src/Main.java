import dao.UsuarioDAO;
import model.Usuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario u1 = new Usuario("renan.silva3@pucpr.edu.br", "Renan da Silva Oliveira Andrade");
        Usuario u2 = new Usuario("pedro.senes@pucpr.edu.br", "Pedro Senes Velloso Ribeiro");

        usuarioDAO.criarUsuario(u1);
        usuarioDAO.criarUsuario(u2);

        ArrayList<Usuario> usuarios = usuarioDAO.listarUsuarios();

        System.out.println(usuarios.size());

        usuarios.forEach((Usuario usuario) -> {
            System.out.print("USUÁRIO ");
            System.out.println(usuario.getIdUsuario());
            System.out.println(usuario.getNome());
            System.out.println(usuario.getEmail());
            System.out.println("----------------------------------");
        });

        usuarios.forEach((Usuario usuario) -> {
            usuario.setNome("Renan Andrade");
            usuarioDAO.atualizarUsuario(usuario);
        });

        usuarios.forEach((Usuario usuario) -> {
            System.out.print("USUÁRIO ");
            System.out.println(usuario.getIdUsuario());
            System.out.println(usuario.getNome());
            System.out.println(usuario.getEmail());
            System.out.println("----------------------------------");
        });

        usuarios.forEach((Usuario usuario) -> {
            usuarioDAO.excluirUsuario(usuario.getIdUsuario());
        });

        usuarios = usuarioDAO.listarUsuarios();

        usuarios.forEach((Usuario usuario) -> {
            System.out.print("USUÁRIO ");
            System.out.println(usuario.getIdUsuario());
            System.out.println(usuario.getNome());
            System.out.println(usuario.getEmail());
            System.out.println("----------------------------------");
        });
    }
}