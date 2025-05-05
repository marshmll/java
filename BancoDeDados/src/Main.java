import dao.UsuarioDAO;
import model.Usuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        Usuario u = new Usuario("email@gmail.com", "1123333");
//        usuarioDAO.criarUsuario(u);
        ArrayList<Usuario> usuarios = usuarioDAO.listarUsuarios();

        usuarios.forEach((Usuario usuario) -> {
            System.out.print("USUÁRIO ");
            System.out.println(usuario.getIdUsuario());
            System.out.println(usuario.getEmail());
            System.out.println(usuario.getSenha());
        });
    }
}