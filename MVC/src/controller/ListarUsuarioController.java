package controller;

import dao.UsuarioDAO;
import model.Usuario;
import view.ListarUsuarioView;

import java.util.ArrayList;

public class ListarUsuarioController {
    public ListarUsuarioController() {
        ListarUsuarioView listarUsuarioView = new ListarUsuarioView();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<Usuario> usuarios = usuarioDAO.listarUsuarios();
        listarUsuarioView.listaUsuarios(usuarios);
    }
}
