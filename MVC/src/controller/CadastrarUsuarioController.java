package controller;

import dao.UsuarioDAO;
import model.Usuario;
import view.CadastrarUsuarioView;

public class CadastrarUsuarioController {

    public CadastrarUsuarioController() {
        CadastrarUsuarioView cadastrarUsuarioView = new CadastrarUsuarioView();
        Usuario usuario = cadastrarUsuarioView.cadastrarUsuario();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        usuarioDao.cadastrarUsuario(usuario);
        cadastrarUsuarioView.cadastroSucesso();
    }
}
